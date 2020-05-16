package com.dudacf26.cloudnative.tema4.Servlet;

import com.dudacf26.cloudnative.tema4.config.AppConfig;
import com.dudacf26.cloudnative.tema4.operacoes.Calculadora;
import com.dudacf26.cloudnative.tema4.operacoes.Operation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calculadora")
public class CalculadoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respon) throws ServletException, IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculadora calculadora = (Calculadora) applicationContext.getBean("calculadora");

        respon.setContentType("text/html");

        PrintWriter out = respon.getWriter();

        String valor1 = request.getParameter("valor1");
        String valor2 = request.getParameter("valor2");
        String operador = request.getParameter("operador");

        try (PrintWriter pw = respon.getWriter()) {


            pw.println("<h2>Primeiro Valor: " + valor1 + "</h2>");
            pw.println("<h2>Segundo Valor:" + valor2 + "</h2>");
            pw.println("<h2>Operação: " + operador + "<h2>");
            pw.println("Result:");
            pw.println(calculadora.executarOperacao(Double.parseDouble(valor1), Double.parseDouble(valor2), operador));
            pw.println("</b> <br>");
            pw.println("Historico:");

            for (Operation operation : calculadora.getHistorico()) {
                pw.println (operation + " <br>");
            }
            pw.println("</h3></body></html>");

        }

        out.println(calculadora.getHistorico());
        ((AnnotationConfigApplicationContext) applicationContext).close();

    }
}

