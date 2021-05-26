package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_item_venda;
    private Long codigoProduto;
    private int qtd;
    private double precoUnitario;
    

    public ItemVenda(int qtd, double precoUnitario, Long codigoProduto){
        this.qtd = qtd;
        this.precoUnitario = precoUnitario;
        this.codigoProduto = codigoProduto;
    }

    protected ItemVenda(){}

    public int getQtd(){
        return this.qtd;
    }

    public double getPrecoUnitario(){
        return this.precoUnitario;
    }

    public Long getCodigoProduto(){
        return this.codigoProduto;
    }

    @Override
    public String toString() {
        return "ItemVenda [Codigo Produto=" + this.codigoProduto + ", Quantidade=" + this.qtd + "]";
    }
    
}
