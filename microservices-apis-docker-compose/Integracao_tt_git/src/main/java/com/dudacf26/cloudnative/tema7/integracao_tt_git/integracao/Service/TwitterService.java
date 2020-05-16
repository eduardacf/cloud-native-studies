package com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Service;

import com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Domain.TwitterDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class TwitterService {

    @Value("${URL_TWITTER}")
    private static String TWITTER;

    public static TwitterDomain listarTwetts(String usuario) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(TWITTER + usuario, TwitterDomain.class);
    }
}
