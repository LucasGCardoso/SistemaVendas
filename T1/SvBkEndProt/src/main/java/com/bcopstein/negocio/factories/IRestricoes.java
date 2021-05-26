package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

public interface IRestricoes {
    boolean temRestricao(ItemVenda[] itens);
}
