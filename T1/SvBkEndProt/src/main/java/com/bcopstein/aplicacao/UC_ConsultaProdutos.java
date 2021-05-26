package com.bcopstein.aplicacao;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProdutos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_ConsultaProdutos {
    private ServicoProdutos servicoProdutos;

    @Autowired
    public UC_ConsultaProdutos(ServicoProdutos servicoProdutos) {
        this.servicoProdutos = servicoProdutos;
    }
    
    public List<Produto> run(){
        return servicoProdutos.listAll();
    }
}
