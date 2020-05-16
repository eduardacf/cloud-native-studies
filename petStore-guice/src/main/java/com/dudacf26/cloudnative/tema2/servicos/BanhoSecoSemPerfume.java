package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.config.Pet;

public class BanhoSecoSemPerfume implements Servico {

    private static double Banho_Seco_Sem_Perfume = 5.0;
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
        return Banho_Seco_Sem_Perfume;
    }

    @Override
    public String executarServico() {
        return "Banho Seco sem Perfume realizado com sucesso ao pet " + pet.getNome();
    }
}
