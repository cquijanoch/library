package org.demo.dto;

import java.io.Serializable;

public class RentalBookDto implements Serializable
{
	private static final long serialVersionUID = -4648674837948322592L;
	
	private Long id;
	private Long idBook;
	private String idUserSession;
	private char state;
	
	public RentalBookDto()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getIdUserSession() {
		return idUserSession;
	}

	public void setIdUserSession(String idUserSession) {
		this.idUserSession = idUserSession;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	
	
}
