package com.dudacf26.cloudnative.tema9.msa;

import com.dudacf26.cloudnative.tema9.rest.CalcService;
import com.dudacf26.cloudnative.tema9.ribbon.RibbonMathClient;
import com.google.inject.AbstractModule;

public class GuiceBindingsModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(RibbonMathClient.class);
    	bind(CalcService.class);
	}
	
}
