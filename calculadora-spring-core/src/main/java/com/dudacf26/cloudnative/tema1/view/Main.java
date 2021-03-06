package com.dudacf26.cloudnative.tema1.view;

import com.dudacf26.cloudnative.tema1.config.AppConfig;
import com.dudacf26.cloudnative.tema1.operacoes.Calculadora;
import com.dudacf26.cloudnative.tema1.operacoes.Operation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculadora calculadora = (Calculadora) applicationContext.getBean("calculadora");

        System.out.println("\n====================== Cálculo de números =====================\n");
        System.out.println("\nO Resultado da Múltiplicação é " + calculadora.executarOperacao(5, 5, "*"));
        System.out.println("\nO Resultado da Divisão é: " + calculadora.executarOperacao(10, 2, "/"));
        System.out.println("\nO Resultado da Soma é: " + calculadora.executarOperacao(5, 5, "+"));
        System.out.println("\nO Resultado da Potênciação é:" + calculadora.executarOperacao(5, 2, "^"));
        System.out.println("\nO Resultado da Subtração é: " + calculadora.executarOperacao(5, 2, "-"));

        System.out.println("\n====================== Histórico =====================\n");
        for (Operation operacao : calculadora.getHistorico()) {
            System.out.println(operacao);
        }

    }
}


