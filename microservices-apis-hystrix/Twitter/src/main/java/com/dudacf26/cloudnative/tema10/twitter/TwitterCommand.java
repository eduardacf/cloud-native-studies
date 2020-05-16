package com.dudacf26.cloudnative.tema10.twitter;

import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterCommand extends HystrixCommand<JsonObject> {
    @Autowired
    private Twitter twitter;
    private String usuario;

    protected TwitterCommand(String usuario) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("twitter"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
        this.usuario = usuario;
    }

    @Override
    protected JsonObject run() throws TwitterException {
        JsonObject respostaTwitter = new JsonObject();
        respostaTwitter.addProperty("Usuário:",usuario);
        respostaTwitter.addProperty("Número de Twetts:", twitter.showUser(usuario).getStatusesCount());
        return respostaTwitter;
    }

    @Override
    protected JsonObject getFallback() {
        JsonObject retornoFallback = new JsonObject();
        retornoFallback.addProperty("Erro", "O usuário não foi localizado: " + usuario);
        return retornoFallback;
    }
}

