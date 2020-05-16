package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.config.Pet;

public interface Servico {

    public String executarServico();

    public void setPet(Pet pet);

    public double getPreco();

    public Pet getPet();
}

