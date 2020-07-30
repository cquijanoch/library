package org.demo.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.demo.business.LoginBusiness;
import org.demo.dto.PersonaDto;
import org.demo.dto.SecurityAccessDto;

import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Login {
	
	@EJB
	LoginBusiness login;
	
	@HEAD
	@Produces(MediaType.APPLICATION_JSON)
	public Response verifyToken(@HeaderParam("authorization") String autorizacion) {

		if (autorizacion == null || autorizacion.contentEquals(""))
			return Response.status(Response.Status.BAD_REQUEST).build();

		if (!(login.isValidAuthentication(autorizacion))) 
			return Response.status(Response.Status.UNAUTHORIZED).build();
		
		 return Response.ok().build();
	}
  
    @POST
    public SecurityAccessDto loginAccess(SecurityAccessDto loginAccess) {
    	SecurityAccessDto session = (SecurityAccessDto) login.identityUser(loginAccess.getNickname(), loginAccess.getPassword()).get("permission");
		return session;
    }

   
}