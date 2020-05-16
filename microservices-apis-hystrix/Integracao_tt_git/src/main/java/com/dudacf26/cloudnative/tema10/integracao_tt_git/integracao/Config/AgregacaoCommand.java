package com.dudacf26.cloudnative.tema10.integracao_tt_git.integracao.Config;

import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AgregacaoCommand extends HystrixCommand<ResponseEntity<String>> {

    private String url;
    private RestTemplate rest;

    public AgregacaoCommand(String url) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("agregacao"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)));
        this.url = url;
        this.rest = new RestTemplate();
    }

    @Override
    protected ResponseEntity<String> run() throws Exception {
        return this.rest.getForEntity(url, String.class);
    }
    protected ResponseEntity<String> getFallBack() {
        JsonObject respostaFallback = new JsonObject();
        respostaFallback.addProperty("Erro:", "Microservico inválido");
        return new ResponseEntity<>(respostaFallback.toString(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
