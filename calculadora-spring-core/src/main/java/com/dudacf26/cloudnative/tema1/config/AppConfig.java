package com.dudacf26.cloudnative.tema1.config;

import com.dudacf26.cloudnative.tema1.operacoes.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.dudacf26.cloudnative.tema1"})
public class AppConfig {

    @Bean
    public Calculadora calculadora(ApplicationContext applicationContext) {
        return new Calculadora(applicationContext);
    }

    @Bean("+")
    @Scope("prototype")
    public Sum sum(double valor1, double valor2) {
        return new Sum(valor1, valor2);
    }

    @Bean("-")
    @Scope("prototype")
    public Sub sub(double valor1, double valor2) {
        return new Sub(valor1, valor2);
    }

    @Bean("/")
    @Scope("prototype")
    public Division division(double valor1, double valor2) {
        return new Division(valor1, valor2);
    }

    @Bean("*")
    @Scope("prototype")
    public Multiply multiply(double valor1, double valor2) {
        return new Multiply(valor1, valor2);
    }

    @Bean("^")
    @Scope("prototype")
    public Pow pow(double valor1, double valor2) {
        return new Pow(valor1, valor2);
    }

}





