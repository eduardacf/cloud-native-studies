package com.dudacf26.cloudnative.tema2.servicos;

import com.dudacf26.cloudnative.tema2.exceptions.ServiceNotFoundException;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Singleton
public class MapServicos {

    private Map<Integer, Supplier<Servico>> mapServicos;


    public MapServicos() {
        this.mapServicos = new HashMap<Integer, Supplier<Servico>>();
        mapServicos.put(1, () -> new BanhoSecoSemPerfume());
        mapServicos.put(2, () -> new BanhoSecoComPerfume());
        mapServicos.put(3, () -> new BanhoMolhadoComPerfume());
        mapServicos.put(4, () -> new BanhoMolhadoSemPerfume());
        mapServicos.put(5, () -> new CorteDeCabeloComprido());
        mapServicos.put(6, () -> new CorteDeCabeloCurto());
    }

    public Servico getMapServicos(int index) {
        try {
            return mapServicos.get(index).get();
        } catch (ServiceNotFoundException erro) {
            throw new ServiceNotFoundException("Id do Servico Inválido!");

        }
    }

}

