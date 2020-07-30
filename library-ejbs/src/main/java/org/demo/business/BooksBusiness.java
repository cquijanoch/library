package org.demo.business;


import java.util.List;

import javax.ejb.Local;

import org.demo.dto.BookDto;

@Local
public interface BooksBusiness {

	public List<BookDto> listBooks();
	public BookDto  registerBook(BookDto newBook);
	public BookDto  editBook(BookDto newBook);
	public BookDto  removeBook(BookDto newBook);

}
