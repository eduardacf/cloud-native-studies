package com.dudacf26.cloudnative.tema9.rest;

import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.dudacf26.cloudnative.tema9.ribbon.RibbonMathClient;

@Singleton
public class CalcService {
	
	private RibbonMathClient client;
	
	@Inject
	public CalcService(RibbonMathClient client) {
		this.client = client;
	}
	
	public Double calc(String expr){
		
		if ( expr==null || ("".equals(expr)) ) 
			throw new IllegalArgumentException("You must pass a valid expression. ");
		
		Stack<String> stack = new Stack<String>();
		String operacao;
		Double valor1;
		Double valor2;
		Double result = 0.0;
		
		for (int i = 0; i < expr.length(); i++){
			operacao = expr.charAt(i) + "";
		     
		     if (" ".equals(operacao)) continue;
		     
		     if(operacao.equals("+") || operacao.equals("-") || operacao.equals("*") || operacao.equals("/") || operacao.equals("^")){
		          switch (operacao){
		                case "+":
							valor1 = new Double(stack.pop());
							valor2 = new Double(stack.pop());
		                    result = client.sum(valor1, valor2).toBlocking().first();
		                    break;
		                case "-":
							valor1 = new Double(stack.pop());
							valor2 = new Double(stack.pop());
		                    result = client.sub(valor1, valor2).toBlocking().first();
		                    break;
		                case "/":
							valor1 = new Double(stack.pop());
							valor2 = new Double(stack.pop());
		                    result = client.div(valor1, valor2).toBlocking().first();
		                    break;
		                case "*":
							valor1 = new Double(stack.pop());
							valor2 = new Double(stack.pop());
		                    result = client.mul(valor1, valor2).toBlocking().first();
		                    break;
					  case "^":
						  valor1 = new Double(stack.pop());
						  valor2 = new Double(stack.pop());
						  result = client.pow(valor1, valor2).toBlocking().first();
						  break;
		                }
		         }else{
		             stack.push(operacao);
		         }
		}
		return result;
		
	}
	
}
