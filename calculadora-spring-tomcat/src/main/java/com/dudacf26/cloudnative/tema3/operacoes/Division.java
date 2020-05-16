package com.dudacf26.cloudnative.tema3.operacoes;

public class Division implements Operation {
    private double valor1;
    private double valor2;

    public Division(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    @Override
    public double calculate() {
        return valor1 / valor2;
    }

    @Override
    public String toString() {
        return "Divisão[" +
                "Valor1: " + valor1 + " " +
                "Valor2: " + valor2 + " " +
                "Resultado: " + calculate() + ']';
    }
}

