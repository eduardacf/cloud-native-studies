package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.config.Pet;

public class CorteDeCabeloComprido implements Servico {

    private static double Corte_De_Cabelo_Comprido = 40.0;
    private Pet pet;

    @Override
    public Pet getPet() {
        return pet;
    }

    @Override
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public double getPreco() {
        return Corte_De_Cabelo_Comprido;
    }

    @Override
    public String executarServico() {
        return "Corte comprido realizado com sucesso ao pet " + pet.getNome();
    }
}
