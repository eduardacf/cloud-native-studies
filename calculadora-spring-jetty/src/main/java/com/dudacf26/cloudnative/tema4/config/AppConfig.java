package com.dudacf26.cloudnative.tema4.config;

import com.dudacf26.cloudnative.tema4.operacoes.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.dudacf26.cloudnative.tema4"})
public class AppConfig {

    @Bean
    public Calculadora calculadora(ApplicationContext applicationContext) {
        return new Calculadora(applicationContext);
    }

    @Bean(name = "somar")
    @Scope("prototype")
    public Sum sum(@Value("${valor1}") double valor1,@Value("${valor2}") double valor2) {
        return new Sum(valor1, valor2);
    }

    @Bean(name = "subtrair")
    @Scope("prototype")
    public Sub sub(@Value("${valor1}") double valor1,@Value("${valor2}")  double valor2) {
        return new Sub(valor1, valor2);
    }

    @Bean(name = "dividir")
    @Scope("prototype")
    public Division division(@Value("${valor1}") double valor1,@Value("${valor2}") double valor2) {
        return new Division(valor1, valor2);
    }

    @Bean(name = "multiplicar")
    @Scope("prototype")
    public Multiply multiply(@Value("${valor1}") double valor1,@Value("${valor2}") double valor2) {
        return new Multiply(valor1, valor2);
    }

    @Bean(name = "potenciacao")
    @Scope("prototype")
    public Pow pow(@Value("${valor1}") double valor1,@Value("${valor2}") double valor2) {
        return new Pow(valor1, valor2);
    }

}





