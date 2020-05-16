package com.dudacf26.cloudnative.tema5.veiculos;

public class Fusca implements Veiculo {

    private final double preco = 2.11;

    @Override
    public double calcularTaxa() {
        return preco;
    }
}
