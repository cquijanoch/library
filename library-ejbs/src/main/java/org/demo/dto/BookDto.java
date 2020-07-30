package org.demo.dto;

import java.io.Serializable;

public class BookDto implements Serializable
{
	private static final long serialVersionUID = -4648674837948322592L;
	
	private Long id;
	private String title;
	private String author;
	private String editorial;
	private int year;
	private char state;
	
	public BookDto()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}
	
	
}
