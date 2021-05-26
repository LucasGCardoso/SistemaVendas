package com.bcopstein.negocio.entidades;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.CascadeType;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    private LocalDateTime data;
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn
    private ItemVenda[] itensVenda;
    private int impostoTotal;
    private int subtotal;

    public Venda(LocalDateTime data, ItemVenda[] itensVenda, int impostoTotal, int subtotal){
        this.data = data;
        this.itensVenda = itensVenda;
        this.impostoTotal = impostoTotal;
        this.subtotal = subtotal;
    }

    protected Venda(){}

    public Long getNumero(){
        return this.numero;
    }

    public LocalDateTime getData(){
        return this.data;
    }

    public ItemVenda[] getItensVenda(){
        return this.itensVenda;
    }

    public int getImpostoTotal(){
        return this.impostoTotal;
    }

    public int getSubtotal(){
        return this.subtotal;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        return "Venda [Número= " + this.numero + ", Data= " + dtf.format(this.data) + "]";
    }
    
    
}
