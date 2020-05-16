package com.dudacf26.cloudnative.tema3.operacoes;

public class Pow implements Operation {
    private double valor1;
    private double valor2;

    public Pow(double valor1,double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    @Override
    public double calculate() {
        return Math.pow(valor1,valor2);
    }

    @Override
    public String toString() {
        return "Potenciação[" +
                "Valor1: " + valor1 + " " +
                "Valor2: " + valor2 + " " +
                "Resultado: " + calculate() + ']';
    }
}

