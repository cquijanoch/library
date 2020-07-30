package org.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = -7250234396452258822L;
	
	@Id
	@GeneratedValue(generator="sqlite_book")
	@TableGenerator(name="sqlite_book",
		table="sqlite_sequence",
	    pkColumnName="name",
	    valueColumnName="seq",
	    pkColumnValue="Book",
	    initialValue=1,
	    allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "editorial")
	private String editorial;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "state")
	private char state;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_inserted")
	private Date dateInserted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_edited")
	private Date dateEdited;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_deleted")
	private Date dateDeleted;
	

	public Book() 
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

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	public Date getDateInserted() {
		return dateInserted;
	}

	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}

	public Date getDateEdited() {
		return dateEdited;
	}

	public void setDateEdited(Date dateEdited) {
		this.dateEdited = dateEdited;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
	
	
	
}
