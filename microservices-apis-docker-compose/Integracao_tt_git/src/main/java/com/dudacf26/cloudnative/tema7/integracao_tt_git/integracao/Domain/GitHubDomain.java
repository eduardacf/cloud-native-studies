package com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Domain;

public class GitHubDomain {

    private String usuario;
    private int numeroRepositorios;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getNumeroRepositorios() {
        return numeroRepositorios;
    }

    public void setNumeroRepositorios(int numeroRepositorios) {
        this.numeroRepositorios = numeroRepositorios;
    }
}
