package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

//no país “Um” cobram-se 12% de IVA

public class ImpostoUm implements ICalculoImposto{
    public int calculaImposto(ItemVenda itens[]){
        int somaImpostos = 0;
        for (ItemVenda itemVenda : itens) {
            somaImpostos += (itemVenda.getPrecoUnitario() * 0.12) * itemVenda.getQtd();
        }
        return somaImpostos;
    }    
}
