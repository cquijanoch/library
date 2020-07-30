package org.demo.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.demo.business.BooksBusiness;
import org.demo.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("library")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Library {
  

	@EJB
	private BooksBusiness usuarioBusiness;
	
    @GET
    public List<BookDto> listBooks()
    {
    	/**
		 * more verification
		 * */
    	List<BookDto> listBooks = new ArrayList<BookDto>();
    	return usuarioBusiness.listBooks();
    }

    @POST
    public BookDto saveBook(BookDto book) {
    	/**
		 * more verification
		 * */
    	return usuarioBusiness.registerBook(book);

    }
    
    @DELETE
    @Path("{id}")
    public BookDto deleteBook(@PathParam("id") Long id) 
    {
    	/**
		 * more verification
		 * */
    	BookDto book = new BookDto();
    	book.setId(id);
    	return usuarioBusiness.removeBook(book);
    }

    @PUT
    @Path("{id}")
    public BookDto editBook(@PathParam("id") BookDto book) 
    {
    	/**
		 * more verification
		 * */
    	return usuarioBusiness.editBook(book);
    }
}