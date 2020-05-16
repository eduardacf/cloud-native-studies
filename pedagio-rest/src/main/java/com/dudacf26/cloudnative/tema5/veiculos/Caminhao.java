package com.dudacf26.cloudnative.tema5.veiculos;

public class Caminhao implements Veiculo {

    private final double preco = 3.95;
    private int eixoAdicional = 0;

    public void setEixoAdicional(int eixoAdicional) {
        this.eixoAdicional = eixoAdicional;
    }

    @Override
    public double calcularTaxa() {
        return preco + (eixoAdicional * 1.00);
    }
}
