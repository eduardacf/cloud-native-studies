package com.dudacf26.cloudnative.tema10.github;

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitHubConfigTest {

    @Test
    public void testaTotalDeRepositorios() {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("{\"Número de Repositórios Públicos no GitHub:\":5,\"Usuario:\":\"dudacf26\"}", restTemplate.getForObject("http://localhost:8080/github/dudacf26", JSONObject.class).toString());
    }
    @Test
    public void testaUsuarioInexistente() {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("{\"Mensagem:\":\" Usuário nao localizado!\",\"Usuário:\":\"naoexisto\"}", restTemplate.getForObject("http://localhost:8080/github/naoexisto", JSONObject.class).toString());
    }
}