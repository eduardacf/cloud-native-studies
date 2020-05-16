package com.dudacf26.cloudnative.tema10.github;

import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;

public class GitHubCommand extends HystrixCommand<JsonObject> {

    private final String usuario;
    private RepositoryService repositoryService;

    protected GitHubCommand(String usuario) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("github"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
        this.usuario = usuario;
        repositoryService = new RepositoryService();
    }

    @Override
    protected JsonObject run() throws IOException {
        JsonObject respostaGithub = new JsonObject();
        respostaGithub.addProperty("User",usuario);
        respostaGithub.addProperty("Número de repositórios:", repositoryService.getRepositories(usuario).size());
        return respostaGithub;
    }

    @Override
    protected JsonObject getFallback() {
        JsonObject retornoFallback = new JsonObject();
        retornoFallback.addProperty("Erro", "O usuário não foi localizado: " + usuario);
        return retornoFallback;
    }
}