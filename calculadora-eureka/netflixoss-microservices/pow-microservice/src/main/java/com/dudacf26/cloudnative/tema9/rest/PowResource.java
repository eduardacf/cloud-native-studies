package com.dudacf26.cloudnative.tema9.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

@Singleton
@Path("/math")
public class PowResource {

	private static final Logger logger = LoggerFactory.getLogger(PowResource.class);
			
	private PowService powService;
	
	@Inject
	public PowResource(PowService powService) {
		this.powService = powService;
	}
	
	@GET
	@Path("pow/{value1}/{value2}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response set(@PathParam("value1") Double value1,@PathParam("value2") Double value2) {
		try {
			return Response.ok( powService.pow(value1, value2) + "" ).build();
		} catch (Exception erro) {
			logger.error("Error creating json response.", erro);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
