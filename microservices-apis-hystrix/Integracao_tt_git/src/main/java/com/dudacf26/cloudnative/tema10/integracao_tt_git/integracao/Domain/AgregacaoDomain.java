package com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Domain;

public class AgregacaoDomain {

    private GitHubDomain usuarioGitHub;
    private TwitterDomain usuarioTwitter;

    public AgregacaoDomain(GitHubDomain usuarioGitHub, TwitterDomain usuarioTwitter) {
        this.usuarioGitHub = usuarioGitHub;
        this.usuarioTwitter = usuarioTwitter;
    }
}
