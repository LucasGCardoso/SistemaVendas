package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;

public interface IVendasRepository {
    List<Venda> listAll();
    //Venda get(Long numero);
    boolean add(Venda venda);
}
