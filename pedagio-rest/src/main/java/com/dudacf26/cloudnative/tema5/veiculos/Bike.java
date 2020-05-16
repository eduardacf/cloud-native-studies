package com.dudacf26.cloudnative.tema5.veiculos;

public class Bike implements Veiculo {

    private final double preco = 0.45;

    @Override
    public double calcularTaxa() {
        return preco;
    }
}
