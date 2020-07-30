package org.demo.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.demo.dao.BookDao;
import org.demo.dto.BookDto;

@Stateless
public class BooksBusinessImpl implements BooksBusiness 
{

	private BookDao bookDao;

	public BookDao getService() 
	{
		return this.bookDao;
	}

	@PostConstruct
	public void initialize() 
	{
		this.bookDao = new BookDao();
	}

	@Override
	public List<BookDto> listBooks() 
	{
		/**
		 * more business logic
		 * */
		return bookDao.getBooks();
	}

	@Override
	public BookDto registerBook(BookDto newBook) {
		/**
		 * more business logic
		 * */
		bookDao.insertBook(newBook);
		return newBook;
	}

	@Override
	public BookDto editBook(BookDto newBook) 
	{
		/**
		 * more business logic
		 * */
		bookDao.editBook(newBook);
		return newBook;

	}

	@Override
	public BookDto removeBook(BookDto newBook) {
		/**
		 * more business logic
		 * */
		bookDao.deleteBook(newBook);
		return newBook;
	}

}
