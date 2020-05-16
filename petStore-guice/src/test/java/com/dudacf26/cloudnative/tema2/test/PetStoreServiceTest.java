package com.dudacf26.cloudnative.tema2.test;

import com.dudacf26.cloudnative.tema2.config.Pet;
import com.dudacf26.cloudnative.tema2.config.PetStoreService;
import com.dudacf26.cloudnative.tema2.exceptions.PetNotFoundException;
import com.dudacf26.cloudnative.tema2.modulo.PetStoreServiceModulo;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PetStoreServiceTest {

    private Injector injector;
    private PetStoreService petstore;

    @Before
    public void init() {
        injector = Guice.createInjector(new PetStoreServiceModulo());
        petstore = injector.getInstance(PetStoreService.class);
    }

    @Test
    public void testAdicionarPet() {
        assertTrue(petstore.adicionarPet("Gael", "naosei", 1));
        assertTrue(petstore.adicionarPet("Joao", "naosei", 10));
        assertTrue(petstore.adicionarPet("Pedro", "naosei", 9));
    }

    @Test
    public void testRemoverPet() {
        assertFalse(petstore.removerPet(1));
        assertFalse(petstore.removerPet(2));
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Pedro", "naosei", 9);
        assertTrue(petstore.removerPet(1));
        assertTrue(petstore.removerPet(2));
    }

    @Test
    public void testBuscarPorIdade() {
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Pedro", "naosei", 10);
        List<Pet> petsEncontradosComAIdadeFornecida = petstore.buscaPorIdade(10);
        assertEquals(1, petsEncontradosComAIdadeFornecida.get(0).getId());
        assertEquals(2, petsEncontradosComAIdadeFornecida.get(1).getId());
    }

    @Test
    public void testBuscarPorIdadeInexistente() {
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Pedro", "naosei", 10);
        List<Pet> petsEncontradosComAIdadeFornecida = petstore.buscaPorIdade(6);
        assertEquals(0, petsEncontradosComAIdadeFornecida.size());
    }

    @Test(expected = PetNotFoundException.class)
    public void testBuscaIdInexistente() {
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Pedro", "naosei", 10);
        petstore.buscarPorId(3);
    }

    @Test
    public void testRealizarServico() {
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Teo", "xauxau", 6);
        petstore.adicionarPet("logan", "tertr", 16);
        petstore.adicionarPet("vitor", "xauxetreau", 61);
        petstore.adicionarPet("paulo", "xautrterxau", 16);
        petstore.adicionarPet("ricardo", "xautrterxau", 16);


        petstore.realizarServico(1, 1);
        petstore.realizarServico(2, 2);
        petstore.realizarServico(3, 3);
        petstore.realizarServico(4, 4);
        petstore.realizarServico(5, 5);
        petstore.realizarServico(6, 6);

        assertEquals(5.0, petstore.buscarPorId(1).getTotalGasto(), 0);
        assertEquals(10.0, petstore.buscarPorId(2).getTotalGasto(), 0);
        assertEquals(20.0, petstore.buscarPorId(3).getTotalGasto(), 0);
        assertEquals(10.0, petstore.buscarPorId(4).getTotalGasto(), 0);
        assertEquals(40.0, petstore.buscarPorId(5).getTotalGasto(), 0);
        assertEquals(20.0, petstore.buscarPorId(6).getTotalGasto(), 0);


    }

    @Test
    public void testTop10() {
        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Teo", "xauxau", 6);
        petstore.adicionarPet("logan", "tertr", 16);
        petstore.adicionarPet("vitor", "xauxetreau", 61);
        petstore.adicionarPet("paulo", "xautrterxau", 16);
        petstore.adicionarPet("ricardo", "xautrterxau", 16);

        petstore.realizarServico(6, 6);
        petstore.realizarServico(6, 6);
        petstore.realizarServico(5, 6);
        petstore.realizarServico(3, 6);

        petstore.realizarServico(5, 1);
        petstore.realizarServico(1, 1);

        petstore.realizarServico(5, 2);
        petstore.realizarServico(1, 2);

        assertEquals(6, petstore.top10().get(0).getId());
        assertEquals(1, petstore.top10().get(1).getId());
        assertEquals(2, petstore.top10().get(2).getId());
    }

    @Test
    public void testHistorico(){

        petstore.adicionarPet("Joao", "naosei", 10);
        petstore.adicionarPet("Teo", "xauxau", 6);
        petstore.adicionarPet("logan", "tertr", 16);

        petstore.realizarServico(6, 1);
        petstore.realizarServico(6, 2);
        petstore.realizarServico(5, 3);

        assertEquals(1, petstore.getHistorico().get(0).getPet().getId());
        assertEquals(2, petstore.getHistorico().get(1).getPet().getId());
        assertEquals(3, petstore.getHistorico().get(2).getPet().getId());
    }
}



