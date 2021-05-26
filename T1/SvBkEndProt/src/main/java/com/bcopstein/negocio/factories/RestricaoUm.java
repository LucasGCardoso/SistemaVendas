package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

public class RestricaoUm implements IRestricoes{

    public boolean temRestricao(ItemVenda[] itens){
        int somaVenda = 0;
        for (ItemVenda itemVenda : itens) {
            if(itemVenda.getQtd() > 2){
                return true;
            }
            somaVenda += itemVenda.getPrecoUnitario() * itemVenda.getQtd();
        }
        if(somaVenda > 10000){
            return true;
        }
        return false;
    }
    
}
