package com.bcopstein.aplicacao;

import java.time.LocalDateTime;

import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoEstoque;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_EfetivarVenda {
    private ServicoEstoque servicoEstoque;
    private ServicoVendas servicoVendas;

    @Autowired
    public UC_EfetivarVenda(ServicoEstoque servicoEstoque, ServicoVendas servicoVendas) {
        this.servicoEstoque = servicoEstoque;
        this.servicoVendas = servicoVendas;
    }
    
    public boolean run(ItemVenda[] itens){

        //Cria uma nova venda e cadastra
        LocalDateTime now = LocalDateTime.now();
        if(servicoVendas.temRestricao(itens))
            return false;
        
        int subtotal = 0;
        for (ItemVenda itemVenda : itens) {
            subtotal += itemVenda.getPrecoUnitario() * itemVenda.getQtd();
        }
        
        Venda venda = new Venda(now, itens, servicoVendas.calculaImposto(itens), subtotal);

        if(this.servicoVendas.add(venda)){
            //BAIXA NO ESTOQUE
            System.out.println("Estoque ANTES da venda: ");
            this.servicoEstoque.listAll().stream().forEach(item -> System.out.println(item));
            //verifica se produto está disponível
            for (ItemVenda itemVenda : itens) {
                if(!this.servicoEstoque.consultaDisponibilidade(itemVenda.getCodigoProduto(), itemVenda.getQtd())){
                    return false;
                }
            }
            //Se está tudo disponível, dá a baixa, abaixando a qtd no estoque daquele produto
            for (ItemVenda itemVenda : itens) {
                this.servicoEstoque.listAll().stream().filter(item -> item.getCodigoProduto() == itemVenda.getCodigoProduto()).forEach(itemEstoque -> itemEstoque.removeQtd(itemVenda.getQtd()));
            }
            System.out.println("Estoque depois da venda: ");
            this.servicoEstoque.listAll().stream().forEach(item -> System.out.println(item));
            this.servicoEstoque.listAll().stream().forEach(item -> this.servicoEstoque.add(item));
            return true;

        }
        return false;
    }
}

