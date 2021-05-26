package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoProdutos {
    private IProdutosRepository produtosRep;

    @Autowired
    // a que está no negocio IVendasRepository
    public ServicoProdutos(IProdutosRepository produtosRep){
        this.produtosRep = produtosRep;
    } 

    public List<Produto> listAll(){
        return produtosRep.listAll();
    }

    public boolean add(Produto produto){
        return produtosRep.add(produto);
    }

    // public Produto get(Long codigo){
    //     return produtosRep.get(codigo);
    // }
}