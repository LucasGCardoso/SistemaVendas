package com.bcopstein.aplicacao;

import com.bcopstein.negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_ConsultaDisponibilidade {
    private ServicoEstoque servicoEstoque;

    @Autowired
    public UC_ConsultaDisponibilidade(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }
    
    public boolean run(Long codProd, int qtd){
        return this.servicoEstoque.consultaDisponibilidade(codProd, qtd);
    }
}
