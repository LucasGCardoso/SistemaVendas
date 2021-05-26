package com.bcopstein.adaptadores.persistencia;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;

import org.springframework.data.repository.CrudRepository;

public interface IProdutosRepositoryJPA extends CrudRepository<Produto, Long> {
    List<Produto> findAll();
    //Produto get(Long codigo);
    //boolean add(Produto item);
    
}

