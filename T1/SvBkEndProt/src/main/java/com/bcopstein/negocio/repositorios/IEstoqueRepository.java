package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {
    List<ItemEstoque> listAll();
    //ItemEstoque get(Long codigoProduto);
    boolean add(ItemEstoque item);
}
