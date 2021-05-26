package com.bcopstein.adaptadores.persistencia;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;

import org.springframework.data.repository.CrudRepository;

public interface IVendasRepositoryJPA extends CrudRepository<Venda, Long> {
    List<Venda> findAll();
    //Venda get(Long codigo);
    //boolean add(Venda item);
    
}

