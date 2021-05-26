package com.bcopstein.adaptadores.persistencia;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EstoqueRepository implements IEstoqueRepository{
    private IEstoqueRepositoryJPA itemEstoqueRepository;

    @Autowired
    public EstoqueRepository(IEstoqueRepositoryJPA itemEstoqueRepository) {
        this.itemEstoqueRepository = itemEstoqueRepository;
    }

    // @Override
    // public ItemEstoque get(Long codigoProduto){
    //     return this.itemEstoqueRepository.get(codigoProduto);
    // }

    @Override
    public List<ItemEstoque> listAll () {
        return this.itemEstoqueRepository.findAll();
    }

    @Override
    public boolean add(ItemEstoque item){
        if(this.itemEstoqueRepository.save(item) instanceof ItemEstoque){
            return true;
        }
        return false;
    }
}