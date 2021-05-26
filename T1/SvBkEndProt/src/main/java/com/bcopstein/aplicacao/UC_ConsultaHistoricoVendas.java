package com.bcopstein.aplicacao;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_ConsultaHistoricoVendas {
    private ServicoVendas servicoVendas;

    @Autowired
    public UC_ConsultaHistoricoVendas(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }
    
    public List<Venda> run(){
        return servicoVendas.listAll();
    }
}
