package com.bcopstein.negocio.factories;

import com.bcopstein.negocio.entidades.ItemVenda;

public interface ICalculoImposto {
    int calculaImposto(ItemVenda itens[]);
}
