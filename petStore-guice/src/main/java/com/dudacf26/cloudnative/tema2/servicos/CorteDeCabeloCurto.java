package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.config.Pet;

public class CorteDeCabeloCurto implements Servico {

    private static double Corte_De_Cabelo_Curto = 20.0;
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
        return Corte_De_Cabelo_Curto;
    }

    @Override
    public String executarServico() {
        return "Corte curto realizado com sucesso ao pet " + pet.getNome();
    }

}
