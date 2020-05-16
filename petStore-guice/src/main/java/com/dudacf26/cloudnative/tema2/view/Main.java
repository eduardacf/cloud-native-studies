package com.dudacf26.cloudnative.tema2.view;

import com.dudacf26.cloudnative.tema2.config.PetStoreService;
import com.dudacf26.cloudnative.tema2.modulo.PetStoreServiceModulo;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PetStoreServiceModulo());
        PetStoreService petService = injector.getInstance(PetStoreService.class);
        System.out.println("*****************************************************");
        System.out.println("Adicionando Pets");
        System.out.println("=====================================================");
        petService.adicionarPet("Teo", "xauxau", 6);
        petService.adicionarPet("logan", "tertr", 16);
        petService.adicionarPet("vitor", "xauxetreau", 61);
        petService.adicionarPet("paulo", "xautrterxau", 16);
        petService.adicionarPet("ricardo", "xautrterxau", 16);
        petService.adicionarPet("samuel", "xautrterxau", 16);
        petService.adicionarPet("otavio", "xautrterxau", 16);
        petService.adicionarPet("vinicius", "xartretuxau", 61);
        System.out.println("\n");

        System.out.println("*****************************************************");
        System.out.println("Removendo Pets");
        System.out.println("=====================================================");
        petService.removerPet(1);
        petService.removerPet(2);
        System.out.println("\n");

        System.out.println("*****************************************************");
        System.out.println("Buscando Pets por Idade:");
        System.out.println("=====================================================");
        System.out.println(petService.buscaPorIdade(16));
        System.out.println("\n");

        System.out.println("*****************************************************");
        System.out.println("Buscando Pets por Id:");
        System.out.println("=====================================================");
        System.out.println(petService.buscarPorId(4));
        System.out.println("\n");

        System.out.println("*****************************************************");
        System.out.println("Realizando serviços:");
        System.out.println("=====================================================");
        System.out.println(petService.realizarServico(3, 8));
        System.out.println(petService.realizarServico(4, 7));
        System.out.println(petService.realizarServico(5, 4));
        System.out.println(petService.realizarServico(6, 3));
        System.out.println(petService.realizarServico(1, 4));
        System.out.println(petService.realizarServico(2, 4));
        System.out.println("\n");

        System.out.println("*****************************************************");
        System.out.println("Listando o Top 10 que mais gastam:");
        System.out.println("=====================================================");
        System.out.println(petService.top10());
        System.out.println("=====================================================");
        System.out.println("Histórico de Servicos:");
        System.out.println(petService.getHistorico());
    }
}
