package com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Service;


import com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Domain.AgregacaoDomain;
import com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Domain.GitHubDomain;
import com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Domain.TwitterDomain;

public class AgregacaoService {

    public static AgregacaoDomain getTweetsRepo(String usuarioTwitter, String usuarioGitHub) {
        TwitterDomain twitter = null;
        GitHubDomain github = null;
        try {
            twitter = TwitterService.listarTwetts(usuarioTwitter);
        } catch (Exception erro) {
            erro.getMessage();
        }
        try {
            github = GitHubService.listarRepositorios(usuarioGitHub);
        } catch (Exception erro) {
            erro.getMessage();
        }
        return new AgregacaoDomain(github,twitter);
    }




}
