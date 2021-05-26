package com.bcopstein.aplicacao;

import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_CalculaSubtotal {
    private ServicoVendas servicoVendas;

    @Autowired
    public UC_CalculaSubtotal(ServicoVendas servicoVendas) {
        this.servicoVendas = servicoVendas;
    }
    
    public Integer[] run(ItemVenda[] itens){
        int subtotal = 0;
        for (ItemVenda itemVenda : itens) {
            subtotal+=itemVenda.getPrecoUnitario() * itemVenda.getQtd();
        }

        int imposto = servicoVendas.calculaImposto(itens);

        final Integer[] resp = new Integer[3];
        resp[0] = subtotal;
        resp[1] = imposto;
        resp[2] = subtotal + imposto;
        return resp;
    }
}
