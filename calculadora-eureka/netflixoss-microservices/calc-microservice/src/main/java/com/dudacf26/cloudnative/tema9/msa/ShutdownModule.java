package com.dudacf26.cloudnative.tema9.msa;

public class ShutdownModule extends netflix.karyon.ShutdownModule{
	
	public ShutdownModule() {
	    super(7006);
	}
	
}
