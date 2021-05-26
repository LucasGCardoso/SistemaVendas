package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.factories.ICalculoImposto;
import com.bcopstein.negocio.factories.IRestricoes;
import com.bcopstein.negocio.factories.ImpostoFactory;
import com.bcopstein.negocio.factories.RestricoesFactory;
import com.bcopstein.negocio.repositorios.IVendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoVendas {
    private IVendasRepository vendasRep;
    private ICalculoImposto calculoImposto;
    private IRestricoes restricoes;

    // public double impostos(){
    //     return 0;
    // }

    @Autowired
    // a que está no negocio IVendasRepository
    public ServicoVendas(IVendasRepository vendasRep, ImpostoFactory impostoFactory, RestricoesFactory restricoesFactory){
        this.vendasRep = vendasRep;
        this.calculoImposto = impostoFactory.getInstance();
        this.restricoes = restricoesFactory.getInstance();
    } 

    public List<Venda> listAll(){
        return vendasRep.listAll();
    }

    public boolean add(Venda venda){
        return vendasRep.add(venda);
    }

    public boolean temRestricao(ItemVenda[] itens){
        return restricoes.temRestricao(itens);
    }


    public int calculaImposto(ItemVenda[] itens){
        return calculoImposto.calculaImposto(itens);
    }

    // public Venda get(Long numero){
    //     return vendasRep.get(numero);
    // }
}