package com.dudacf26.cloudnative.tema8.CalculadoraRXNetty;

import com.dudacf26.cloudnative.tema8.config.AppConfig;
import com.dudacf26.cloudnative.tema8.operacoes.Calculadora;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rx.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    private Calculadora calculadora = new Calculadora(applicationContext);

    private static final int VALOR1 = 3;
    private static final int VALOR2 = 2;
    private static final int OPERACAO = 1;

    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;
    private Map<String, String> operacoes;

    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint, HealthCheckEndpoint healthCheckEndpoint1) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint1;
        this.operacoes = new HashMap<String, String>() {{
            put("somar", "+");
            put("subtrair", "-");
            put("multiplicar", "*");
            put("dividir", "/");
            put("potencia", "^");
        }};
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith(healthCheckUri)) {
            return healthCheckEndpoint.handle(request, response);
        } else if (request.getUri().startsWith("/calculadora/")) {
            try {
                String[] parametros = request.getUri().split("/");
                String tipoOperacao = parametros[OPERACAO];
                String valor1 = parametros[VALOR1];
                String valor2 = parametros[VALOR2];

                Double result = calculadora.executarOperacao(Double.parseDouble(valor1), Double.parseDouble(valor2), tipoOperacao);
                response.setStatus(HttpResponseStatus.OK);
                return response.writeStringAndFlush("{\"Resultado\":\"" + result + "\"}");

            } catch (NumberFormatException e) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush(
                        "{\"Erro\":\"O valor inserido deve ser um número!\"}");
            } catch (IllegalArgumentException e) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush(
                        "{\"Erro\":\"A Operação inserida é inválida!\"}");
            }
        } else if (request.getUri().startsWith("/historico")) {
            response.setStatus(HttpResponseStatus.OK);
            return response.writeStringAndFlush(calculadora.getHistorico().toString());
        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            return response.close();
        }
    }
}


