package com.dudacf26.cloudnative.tema5.test;

import com.dudacf26.cloudnative.tema5.veiculos.*;
import org.junit.Test;
import io.restassured.RestAssured;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PagamentoServiceTest {

    private Bike bike;
    private Caminhao caminhao;
    private Onibus onibus;
    private Fusca fusca;
    private Moto moto;

    @Test
    public void testPrecoCaminhao() {
        Caminhao caminhao = new Caminhao();
        assertEquals(3.95, caminhao.calcularTaxa(), 0);
    }
    @Test
    public void testPrecoMoto() {
        Moto moto = new Moto();
        assertEquals(1, moto.calcularTaxa(), 0.001);
    }
    @Test
    public void testPrecoFusca() {
        Fusca fusca = new Fusca();
        assertEquals(2.11, fusca.calcularTaxa(), 0);
    }
    @Test
    public void testPrecoOnibus() {
        Onibus onibus = new Onibus();
        assertEquals(1.59, onibus.calcularTaxa(), 0);
    }
    @Test
    public void testPrecoBike() {
        Bike bike = new Bike();
        assertEquals(0.45, bike.calcularTaxa(), 0);
    }
    @Test
    public void testPedagioBikeComTroco() {
        assertTrue(RestAssured.get("http://localhost:8080/rest/pedagio/bike/5").asString().contains("4.55"));
    }
    @Test
    public void testPedagioMotoComTroco() {
        assertTrue(RestAssured.get("http://localhost:8080/rest/pedagio/moto/5").asString().contains("4.0"));
    }
    @Test
    public void testPedagioOnibusComTroco() {
        assertTrue(RestAssured.get("http://localhost:8080/rest/pedagio/pagamento/onibus/30").asString().contains("3.41"));
    }
    @Test
    public void testPedagioCaminhaoComTroco() {
        assertTrue(RestAssured.get("http://localhost:8080/rest/pedagio/caminhao/2/10").asString().contains("4.05"));
    }
}
