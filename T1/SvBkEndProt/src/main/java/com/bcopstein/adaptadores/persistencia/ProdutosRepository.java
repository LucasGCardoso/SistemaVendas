package com.bcopstein.adaptadores.persistencia;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProdutosRepository implements IProdutosRepository{
    private IProdutosRepositoryJPA produtosRepository;

    @Autowired
    public ProdutosRepository(IProdutosRepositoryJPA produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @Override
    public List<Produto> listAll () {
        return this.produtosRepository.findAll();
    }

    // @Override
    // public Produto get(Long codigo) {
    //     return this.produtosRepository.get(codigo);
    // }

    @Override
    public boolean add(Produto produto) {
        if(this.produtosRepository.save(produto) instanceof Produto){
            return true;
        }
        return false;
    }
    
}