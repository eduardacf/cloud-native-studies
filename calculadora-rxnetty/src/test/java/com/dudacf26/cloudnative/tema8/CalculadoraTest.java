package com.dudacf26.cloudnative.tema8;

import com.dudacf26.cloudnative.tema8.config.AppConfig;
import com.dudacf26.cloudnative.tema8.exception.DivisionByZeroException;
import com.dudacf26.cloudnative.tema8.exception.InvalidOperationException;
import com.dudacf26.cloudnative.tema8.operacoes.Calculadora;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

public class CalculadoraTest {

    private Calculadora calculadora;
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        calculadora = new Calculadora(applicationContext);
    }

    @Test
    public void testaSoma() {
        assertEquals(18, calculadora.executarOperacao(9, 9, "+"), 0);
        assertEquals(-18, calculadora.executarOperacao(-9, -9, "+"), 0);
        assertEquals(10, calculadora.executarOperacao(5, 5, "+"), 0);
    }

    @Test
    public void testaSub() {
        assertEquals(5, calculadora.executarOperacao(9, 4, "-"), 0);
        assertEquals(400, calculadora.executarOperacao(500, 100, "-"), 0);
        assertEquals(-5, calculadora.executarOperacao(-9, -4, "-"), 0);
    }

    @Test
    public void testaMult() {
        assertEquals(42, calculadora.executarOperacao(7, 6, "*"), 0);
        assertEquals(25, calculadora.executarOperacao(5, 5, "*"), 0);
        assertEquals(100, calculadora.executarOperacao(10, 10, "*"), 0);
    }

    @Test
    public void testaDiv() {
        assertEquals(2, calculadora.executarOperacao(10, 5, "/"), 0);
        assertEquals(50, calculadora.executarOperacao(100, 2, "/"), 0);
        assertEquals(200, calculadora.executarOperacao(2000, 10, "/"), 0);
    }

    @Test
    public void testaPotenciacao() {
        assertEquals(16, calculadora.executarOperacao(4, 2, "^"), 0);
        assertEquals(27, calculadora.executarOperacao(3, 3, "^"), 0);
        assertEquals(32, calculadora.executarOperacao(2, 5, "^"), 0);
    }

    @Test(expected = DivisionByZeroException.class)
    public void testDivisaoPor0() {
        calculadora.executarOperacao(4, 0, "/");
    }

    @Test(expected = InvalidOperationException.class)
    public void testOperacaoInválida() {
        calculadora.executarOperacao(2, 2, "xxxxx");
    }

    @Test
    public void testeHistorico() {
        calculadora.executarOperacao(10, 5, "+");
        calculadora.executarOperacao(15, 5, "+");


        calculadora.executarOperacao(10, 5, "*");
        calculadora.executarOperacao(15, 5, "*");


        calculadora.executarOperacao(2, 2, "^");
        calculadora.executarOperacao(2, 3, "^");


        calculadora.executarOperacao(4, 2, "-");
        calculadora.executarOperacao(6, 2, "-");


        calculadora.executarOperacao(10, 2, "/");
        calculadora.executarOperacao(20, 2, "/");


        assertEquals(15.0, calculadora.getHistorico().get(0).calculate(),0);
        assertEquals(20.0, calculadora.getHistorico().get(1).calculate(),0);

        assertEquals(50.0, calculadora.getHistorico().get(2).calculate(),0);
        assertEquals(75.0, calculadora.getHistorico().get(3).calculate(),0);

        assertEquals(4.0, calculadora.getHistorico().get(4).calculate(),0);
        assertEquals(8.0, calculadora.getHistorico().get(5).calculate(),0);

        assertEquals(2.0, calculadora.getHistorico().get(6).calculate(),0);
        assertEquals(4.0, calculadora.getHistorico().get(7).calculate(),0);

        assertEquals(5.0, calculadora.getHistorico().get(8).calculate(),0);
        assertEquals(10.0, calculadora.getHistorico().get(9).calculate(),0);

    }
}



