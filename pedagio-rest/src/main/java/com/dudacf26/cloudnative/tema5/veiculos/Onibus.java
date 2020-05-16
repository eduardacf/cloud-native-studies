package com.dudacf26.cloudnative.tema5.veiculos;

public class Onibus implements Veiculo {

    private final double preco = 1.59;

    @Override
    public double calcularTaxa() {
        return preco;
    }

}
