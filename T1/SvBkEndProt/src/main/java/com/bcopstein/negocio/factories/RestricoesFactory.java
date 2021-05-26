package com.bcopstein.negocio.factories;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class RestricoesFactory{

    public IRestricoes getInstance(){
        LocalTime time1 = LocalTime.parse("16:00:00.00");
        if(LocalTime.now().isAfter(time1)){
            System.out.println("Usando restrição um");
            return new RestricaoUm();
        }else{
            System.out.println("Usando restrição dois");
            return new RestricaoDois();
        }
    }
}
