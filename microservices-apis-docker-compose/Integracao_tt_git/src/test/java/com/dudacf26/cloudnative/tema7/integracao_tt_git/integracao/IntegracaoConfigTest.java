package com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegracaoConfigTest {
    @Test
    public void testaIntegracao() {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("{\"Número de Twetts:\":109,\"Usuario:\":\"dudaf26\"}{\"Número de Repositórios Públicos no GitHub:\":5,\"Usuario:\":\"dudacf26\"}", restTemplate.getForObject("http://localhost:8080/twitter/dudaf26/github/dudacf26", JSONObject.class).toString());
    }
}
