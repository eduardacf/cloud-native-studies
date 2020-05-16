package com.dudacf26.cloudnative.tema2.config;

import com.dudacf26.cloudnative.tema2.GeradorDeId;
import com.dudacf26.cloudnative.tema2.exceptions.PetNotFoundException;
import com.dudacf26.cloudnative.tema2.servicos.MapServicos;
import com.dudacf26.cloudnative.tema2.servicos.Servico;
import com.google.inject.Injector;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class PetStoreService {

    private Injector injector;
    private List<Pet> pets;
    private List<Servico> historico;
    private MapServicos mapServicos;

    @Inject
    public PetStoreService(MapServicos mapServicos) {
        this.pets = new ArrayList<Pet>();
        historico = new ArrayList<Servico>();
        this.mapServicos = mapServicos;
    }

    @Inject
    private GeradorDeId geradorDeId;

    public boolean adicionarPet(String nome, String raca, int idade) {
            pets.add(new Pet(geradorDeId.gerarId(), nome, raca, idade));
            System.out.println("O Cão " + nome + " foi adicionado com sucesso :)");
            return true;
    }

    public boolean removerPet(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                pets.remove(pet);
                System.out.println("O Cão " + pet.getNome() + " foi removido com sucesso :)");
                return true;
            }
        }
        System.out.println("Cão com ID" + id + "não foi encontrado para remoção!");
        return false;
    }

    public List<Pet> buscaPorIdade(int idade) {
        List<Pet> petsEncontradosComAIdadeFornecida = pets.stream().filter(pet -> pet.getIdade() == idade).collect(Collectors.toList());
        System.out.println("Pets localizados com a Idade de: " + idade);
        return petsEncontradosComAIdadeFornecida;
    }

    public Pet buscarPorId(int id) {
        return pets.stream().filter(pet -> pet.getId() == id).findAny().orElseThrow(() -> new PetNotFoundException("Pet com ID" + id + "não foi encontrado :("));
    }

    public String realizarServico(int tipoServico, int idPet) {
        Servico servico = mapServicos.getMapServicos(tipoServico);
        servico.setPet(buscarPorId(idPet));
        servico.getPet().setServices(servico);
        historico.add(servico);

        return servico.executarServico();
    }

    public List<Pet> top10() {
        List<Pet> top10 = pets;
        Collections.sort(top10, Comparator.comparing(Pet::getTotalGasto).reversed());
        if (top10.size() > 10) {
            top10 = top10.subList(0, 10);
        }
        return top10;
    }

    public List<Servico> getHistorico() {
        return historico;
    }

}






