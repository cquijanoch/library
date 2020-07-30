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
@Table(name = "rentalBook")
public class RentalBook implements Serializable {
	private static final long serialVersionUID = -7250234396452258822L;
	
	@Id
	@GeneratedValue(generator="sqlite_rentalbook")
	@TableGenerator(name="sqlite_rentalbook",
		table="sqlite_sequence",
	    pkColumnName="name",
	    valueColumnName="seq",
	    pkColumnValue="RentalBook",
	    initialValue=1,
	    allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "idUser")
	private String idUser;
	
	@Column(name = "idBook")
	private Long idBook;
	
	@Column(name = "state")
	private char state;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateRental")
	private Date dateRental;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateReturn")
	private Date dateReturn;

	public RentalBook() 
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	public Date getDateRental() {
		return dateRental;
	}

	public void setDateRental(Date dateRental) {
		this.dateRental = dateRental;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	
}
