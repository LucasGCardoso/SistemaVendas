package com.bcopstein.adaptadores.persistencia;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendasRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VendasRepository implements IVendasRepository{
    private IVendasRepositoryJPA vendasRepository;

    @Autowired
    public VendasRepository(IVendasRepositoryJPA vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    @Override
    public List<Venda> listAll () {
        return this.vendasRepository.findAll();
    }

    // @Override
    // public Venda get(Long codigo) {
    //     return this.vendasRepository.get(codigo);
    // }

    @Override
    public boolean add(Venda venda) {
        if(this.vendasRepository.save(venda) instanceof Venda){
            return true;
        }
        return false;
    }

}