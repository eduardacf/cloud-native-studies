package com.dudacf26.cloudnative.tema9.ribbon;


import io.reactivex.netty.protocol.http.client.HttpClientResponse;

import com.netflix.ribbon.ResponseValidator;
import com.netflix.ribbon.ServerError;
import com.netflix.ribbon.UnsuccessfulResponseException;


@SuppressWarnings("rawtypes")
public class SimpleResponseValidator implements ResponseValidator<HttpClientResponse> {

	@Override
	public void validate(HttpClientResponse response) throws UnsuccessfulResponseException,ServerError {
		System.out.println("Validator: " + response);
	}

}