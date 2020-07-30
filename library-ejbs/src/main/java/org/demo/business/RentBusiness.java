package org.demo.business;

import javax.ejb.Local;

import org.demo.dto.BookDto;
import org.demo.dto.RentalBookDto;
import org.demo.dto.SecurityAccessDto;

@Local
public interface RentBusiness {

	public RentalBookDto  rentBook(BookDto newBook, SecurityAccessDto session);
	public RentalBookDto  returnBook(BookDto newBook, SecurityAccessDto session);

}
