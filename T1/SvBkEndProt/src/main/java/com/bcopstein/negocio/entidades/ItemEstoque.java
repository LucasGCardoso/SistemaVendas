package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEstoque {
    @Id
    private Long codigoProduto;
    private int qtd;

    public ItemEstoque(Long codigoProduto, int qtd){
        this.codigoProduto = codigoProduto;
        this.qtd = qtd;
    } 

    protected ItemEstoque(){}

    public Long getCodigoProduto(){
        return this.codigoProduto;
    }

    public int getQtd(){
        return this.qtd;
    }

    public void removeQtd(int qtd){
        this.qtd -= qtd;
    }

    @Override
    public String toString() {
        return "ItemEstoque [Codigo Produto=" + codigoProduto + ", Quantidade=" + qtd + "]";
    }

}
