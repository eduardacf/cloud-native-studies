package com.dudacf26.cloudnative.tema5.config;

import com.dudacf26.cloudnative.tema5.veiculos.*;
import org.springframework.stereotype.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Service
@ApplicationPath("/pedagio")
public class PagamentoService extends Application {

    private Map<String, Double> pricetable;

    public PagamentoService() {
        pricetable = new HashMap<String, Double>();
        pricetable.put("Bike", 0.49);
        pricetable.put("Onibus", 1.59);
        pricetable.put("Fusca", 2.11);
        pricetable.put("Moto", 1.00);
        pricetable.put("Caminhão - (Eixo Adicional + R$1)", 3.95);
    }

    public Response calcularPagamento(double valorFornecido, Veiculo veiculo) {
        double result = 0;

        if (valorFornecido > veiculo.calcularTaxa()) {
            result = valorFornecido - veiculo.calcularTaxa();
            return Response.ok("Pode prosseguir a Viagem seu Troco é : " + result).build();

        } else if (valorFornecido < veiculo.calcularTaxa()) {
            result = valorFornecido - veiculo.calcularTaxa();
            return Response.ok("Dinheiro Insuficiente para o pedágio: " + result).build();
        } else {
            result = valorFornecido - veiculo.calcularTaxa();
            return Response.ok("Pode prosseguir a viagem :) " + result).build();
        }
    }

    @GET
    @Path("/tabelaDePrecos")
    @Produces("application/json")
    public Response tabelaDePrecos() {
        Response.ResponseBuilder response = Response.ok(pricetable);
        return response.build();
    }

    @GET
    @Path("/caminhao/{eixoAdicional}/{valorFornecido}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caminhao(@PathParam("eixoAdicional") int eixoAdicional, @PathParam("valorFornecido") double valorFornecido) {
        Caminhao caminhao = new Caminhao();
        caminhao.setEixoAdicional(eixoAdicional);
        return calcularPagamento(valorFornecido, caminhao);
    }

    @GET
    @Path("/bike/{valorFornecido}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bike(@PathParam("valorFornecido") double valorFornecido) {
        Bike bike = new Bike();
        return calcularPagamento(valorFornecido, bike);
    }

    @GET
    @Path("/onibus/{valorFornecido}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response onibus(@PathParam("valorFornecido") double valorFornecido) {
        Onibus onibus = new Onibus();
        return calcularPagamento(valorFornecido, onibus);
    }

    @GET
    @Path("/fusca/{valorFornecido}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fusca(@PathParam("valorFornecido") double valorFornecido) {
        Fusca fusca = new Fusca();
        return calcularPagamento(valorFornecido, fusca);
    }

    @GET
    @Path("/moto/{valorFornecido}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response motorcycleTax(@PathParam("valorFornecido") double valorFornecido) {
        Moto moto = new Moto();
        return calcularPagamento(valorFornecido, moto);
    }

}
