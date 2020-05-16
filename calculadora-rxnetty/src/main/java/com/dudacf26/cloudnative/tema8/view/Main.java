package com.dudacf26.cloudnative.tema8.view;

import com.dudacf26.cloudnative.tema8.CalculadoraRXNetty.HealthCheck;
import com.dudacf26.cloudnative.tema8.CalculadoraRXNetty.RxNettyHandler;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;

public class Main {
    public static void main(String[] args) {

        HealthCheckHandler healthCheckHandler = new HealthCheck();
        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheckHandler), healthCheckEndpoint1),
                new KaryonBootstrapModule(healthCheckHandler),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();
    }
}
