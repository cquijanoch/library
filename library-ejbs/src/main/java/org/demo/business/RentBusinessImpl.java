package org.demo.business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.demo.dao.RentalBookDao;
import org.demo.dto.BookDto;
import org.demo.dto.RentalBookDto;
import org.demo.dto.SecurityAccessDto;

@Stateless
public class RentBusinessImpl implements RentBusiness 
{

	private RentalBookDao rentalDao;

	public RentalBookDao getService() 
	{
		return this.rentalDao;
	}

	@PostConstruct
	public void initialize() 
	{
		this.rentalDao = new RentalBookDao();
	}

	@Override
	public RentalBookDto rentBook(BookDto newBook, SecurityAccessDto session) 
	{
		/**
		 * more business logic
		 * */
		RentalBookDto rental = null;
		if (!rentalDao.isBookRentedByBookId(newBook.getId()))
		{
			rental = new RentalBookDto();
			rental.setIdBook(newBook.getId());
			rental.setIdUserSession(session.getId());
			rentalDao.rentalBook(rental);
		}
		return rental;
	}

	@Override
	public RentalBookDto returnBook(BookDto newBook, SecurityAccessDto session)
	{
		/**
		 * more business logic
		 * */
		RentalBookDto rental = null;
		if (rentalDao.isBookRentedByBookId(newBook.getId()))
		{
			rental = new RentalBookDto();
			rental.setIdBook(newBook.getId());
			rental.setIdUserSession(session.getId());
			rentalDao.returnBook(rental);
		}
		return rental;
	}	

}

