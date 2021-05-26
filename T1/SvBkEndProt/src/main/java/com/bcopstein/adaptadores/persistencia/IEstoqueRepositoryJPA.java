package com.bcopstein.adaptadores.persistencia;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface IEstoqueRepositoryJPA extends CrudRepository<ItemEstoque, Long>{
    List<ItemEstoque> findAll();
    //ItemEstoque get(Long codigoProduto);
    //boolean add(ItemEstoque item);
    
}
