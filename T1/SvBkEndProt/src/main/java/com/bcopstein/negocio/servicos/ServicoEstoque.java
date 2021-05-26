package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstoque {
    private IEstoqueRepository estoqueRep;

    @Autowired
    // a que está no negocio IVendasRepository
    public ServicoEstoque(IEstoqueRepository estoqueRep){
        this.estoqueRep = estoqueRep;
    } 

    public List<ItemEstoque> listAll(){
        return estoqueRep.listAll();
    }

    public boolean add(ItemEstoque item){
        return estoqueRep.add(item);
    }

    public boolean baixaEstoque(ItemVenda[] itens){
        System.out.println("Estoque ANTES da venda: ");
        this.listAll().stream().forEach(item -> System.out.println(item));
        //verifica se produto está disponível
        for (ItemVenda itemVenda : itens) {
            if(!consultaDisponibilidade(itemVenda.getCodigoProduto(), itemVenda.getQtd())){
                return false;
            }
        }
        //Se está tudo disponível, dá a baixa, abaixando a qtd no estoque daquele produto
        for (ItemVenda itemVenda : itens) {
            this.listAll().stream().filter(item -> item.getCodigoProduto() == itemVenda.getCodigoProduto()).forEach(itemEstoque -> itemEstoque.removeQtd(itemVenda.getQtd()));
        }
        System.out.println("Estoque depois da venda: ");
        this.listAll().stream().forEach(item -> System.out.println(item));
        this.listAll().stream().forEach(item -> this.add(item));
        return true;  
    }

    public boolean consultaDisponibilidade(Long codProd, int qtd){
        return this.listAll().stream().anyMatch(item -> item.getCodigoProduto() == codProd && item.getQtd() >= qtd);
    }

    // public Produto get(Long codigo){
    //     return produtosRep.get(codigo);
    // }
}