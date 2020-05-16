package com.dudacf26.cloudnative.tema2.config;

import com.dudacf26.cloudnative.tema2.servicos.Servico;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private int id;
    private String nome;
    private String raca;
    private int idade;
    private double totalGasto;
    private List<Servico> servicos = new ArrayList<>();


    public Pet(int id, String nome, String raca, int idade) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServices(Servico servico) {
        this.servicos = servicos;
        this.totalGasto += servico.getPreco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "ID:" + id +
                " Nome:'" + nome + '\'' +
                " Raca:'" + raca + '\'' +
                " Idade:" + idade + '\'' +
                " Total Gasto do pet:" + totalGasto + "\n";
    }
}


