package com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Service;

import com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Domain.GitHubDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class GitHubService {

    @Value("${URL_GITHUB}")
    private static String GITHUB;

    public static GitHubDomain listarRepositorios(String usuario) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(GITHUB + usuario, GitHubDomain.class);    }
}
