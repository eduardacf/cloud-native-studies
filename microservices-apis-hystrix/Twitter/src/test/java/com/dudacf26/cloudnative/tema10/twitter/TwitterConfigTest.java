package com.dudacf26.cloudnative.tema10.twitter;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

public class TwitterConfigTest {

    @Test
    public void testaTotalDeTwetts() {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("{\"Número de Twetts:\":109,\"Usuario:\":\"dudaf26\"}", restTemplate.getForObject("http://localhost:8080/twitter/dudaf26", JSONObject.class).toString());
    }

    @Test
    public void testaUsuarioInexistenteTwitter() {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("{\"Mensagem:\":\" Usuário nao localizado!\",\"Usuário:\":\"essetwitternaoexiste\"}", restTemplate.getForObject("http://localhost:8080/twitter/essetwitternaoexiste", JSONObject.class).toString());
    }
}
