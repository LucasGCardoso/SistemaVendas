package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;

public interface IProdutosRepository {
    List<Produto> listAll();
    //Produto get(Long codigo);
    boolean add(Produto produto);
}
