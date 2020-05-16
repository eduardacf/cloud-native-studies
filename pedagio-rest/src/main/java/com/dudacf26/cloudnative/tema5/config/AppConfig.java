package com.dudacf26.cloudnative.tema5.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsSErver() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(pagamentoService(), JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.asList(pagamentoService()));
        factory.setProviders(Arrays.asList(jsonProvider()));
        return factory.create();
    }
    @Bean
    public PagamentoService pagamentoService() {
        return new PagamentoService();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}
