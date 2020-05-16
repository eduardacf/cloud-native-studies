package com.dudacf26.cloudnative.tema5.veiculos;

public class Moto implements Veiculo {

    private final double preco = 1.00;

    @Override
    public double calcularTaxa() {
        return preco;
    }
}
