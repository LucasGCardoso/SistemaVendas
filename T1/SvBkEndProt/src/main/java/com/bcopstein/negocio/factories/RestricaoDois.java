package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

public class RestricaoDois implements IRestricoes{

    public boolean temRestricao(ItemVenda[] itens){
        for (ItemVenda itemVenda : itens) {
            if(itemVenda.getQtd() > 4){
                return true;
            }
        }
        return false;
    }
}
