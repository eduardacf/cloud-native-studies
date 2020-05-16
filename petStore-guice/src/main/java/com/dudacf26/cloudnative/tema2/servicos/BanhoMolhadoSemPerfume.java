package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.config.Pet;

public class BanhoMolhadoSemPerfume implements Servico {

    private static double Banho_Molhado_Sem_Perfume = 10.0;
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
        return Banho_Molhado_Sem_Perfume;
    }

    @Override
    public String executarServico() {
        return "Banho Molhado sem Perfume realizado com sucesso ao pet " + pet.getNome();
    }
}
