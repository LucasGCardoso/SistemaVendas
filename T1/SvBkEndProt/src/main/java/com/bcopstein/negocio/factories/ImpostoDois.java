package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

// No país “Dois” o IVA é de 15% para compras até $8000,00 e de 20% para o que exceder valores maiores.

public class ImpostoDois implements ICalculoImposto{
    public int calculaImposto(ItemVenda itens[]){
        int somaPrecos = 0;
        int somaImposto15 = 0;
        int somaImposto20 = 0;
        for (ItemVenda itemVenda : itens) {
            somaPrecos += itemVenda.getPrecoUnitario() * itemVenda.getQtd();
            somaImposto15 += (itemVenda.getPrecoUnitario()*0.15) * itemVenda.getQtd();
            somaImposto20 += (itemVenda.getPrecoUnitario()*0.20) * itemVenda.getQtd();
        }
        if(somaPrecos <= 8000){
            return somaImposto15;
        }else{
            return somaImposto20;
        }
    }    
}
