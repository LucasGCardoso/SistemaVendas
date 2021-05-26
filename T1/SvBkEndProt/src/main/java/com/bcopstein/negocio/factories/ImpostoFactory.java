package com.bcopstein.negocio.factories;

import org.springframework.stereotype.Component;

@Component
public class ImpostoFactory {
    static ICalculoImposto instance;

    private ImpostoFactory(){
    }

    public ICalculoImposto getInstance(){
        if(instance == null){
            instance = new ImpostoUm();
        }
        return instance;
    }
}
