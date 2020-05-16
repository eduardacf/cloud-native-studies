package com.dudacf26.cloudnative.tema3.operacoes;

import com.dudacf26.cloudnative.tema3.exception.DivisionByZeroException;
import com.dudacf26.cloudnative.tema3.exception.InvalidOperationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    @Autowired
    private ApplicationContext applicationContext;

    private List<Operation> historico = new ArrayList<>();

    public Calculadora(ApplicationContext applicationContext) {
        this.historico = new ArrayList<Operation>();
        this.applicationContext = applicationContext;
    }

    public double executarOperacao(double valor1, double valor2, String operador) {
        try {
            Operation operation = (Operation) applicationContext.getBean(operador, valor1, valor2);
            Double result = operation.calculate();
            historico.add(operation);
            return result;
        } catch (BeansException e) {
            throw new InvalidOperationException("Operação Inválida!");
        } catch (DivisionByZeroException e) {
            throw e;
        }
    }

    public List<Operation> getHistorico() {
        return historico;
    }

}





