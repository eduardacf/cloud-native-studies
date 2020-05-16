package com.dudacf26.cloudnative.tema2.modulo;

import com.dudacf26.cloudnative.tema2.servicos.MapServicos;
import com.dudacf26.cloudnative.tema2.config.PetStoreService;
import com.google.inject.AbstractModule;

public class PetStoreServiceModulo extends AbstractModule {
    protected void configure() {

        bind(MapServicos.class);
        bind(PetStoreService.class);
    }
}
