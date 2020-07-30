package org.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.demo.dto.BookDto;
import org.demo.entities.Book;

import static org.demo.util.Constants.*;


public class BookDao extends GeneralDao
{
	
	private static final Logger logger = Logger.getLogger(BookDao.class.getName());
	
	public List<BookDto> getBooks()
	{
		EntityManager entityManager = getEntityManager();
		List<BookDto> books = new ArrayList<BookDto>();
        try
        {
        	Query q = entityManager.createQuery("SELECT b FROM Book b WHERE b.state = :state ORDER BY b.title ");
        	q.setParameter("state", STATE_ACTIVE);
        	List<Book> library = q.getResultList();
        	for (Book book : library)
        	{
        		BookDto bookDto = new BookDto();
        		bookDto.setId(book.getId());
        		bookDto.setTitle(book.getTitle());
        		bookDto.setAuthor(book.getAuthor());
        		bookDto.setState(book.getState());
        		books.add(bookDto);
        	}
        }
        catch(Throwable e)
		{
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
	    }
        finally
        {
        	if (entityManager != null)
        		entityManager.close();
		}
        return books;
    }
	
	public BookDto getBookById(Long id)
	{
		EntityManager entityManager = getEntityManager();
		BookDto bookDto = null;
		try
        {
        	Book book = entityManager.find(Book.class, id);
        	bookDto = new BookDto();
    		bookDto.setAuthor(book.getAuthor());
    		bookDto.setTitle(book.getTitle());
    		bookDto.setYear(book.getYear());
    		bookDto.setId(id);
    		bookDto.setEditorial(book.getEditorial());
    		bookDto.setState(book.getState());
    		//Include detail of Book
        }
        catch (Throwable e)
		{
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
	    }	
		finally
        {
        	if (entityManager != null)
        		entityManager.close();
		}
		return bookDto;
	}
	
	public boolean insertBook(BookDto book)
	{
		EntityManager entityManager = getEntityManager();
        try
        {
        	entityManager.getTransaction().begin();
        	Book newBook = new Book();
    		newBook.setTitle(book.getTitle());
    		newBook.setAuthor(book.getAuthor());
    		newBook.setYear(book.getYear());
    		newBook.setEditorial(book.getEditorial());
    		newBook.setState(STATE_ACTIVE);
    		newBook.setDateInserted(new Date());
    		entityManager.persist(newBook);
    		entityManager.getTransaction().commit();
        	book.setId(newBook.getId());
        	book.setState(newBook.getState());
        }
        catch(Throwable e)
		{
        	e.printStackTrace();
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
        	entityManager.getTransaction().rollback();
        	return false;
	    }
        finally
        {
        	if (entityManager != null)
        		entityManager.close();
		}
		return true;
	}
	
	public boolean editBook(BookDto book)
	{
		EntityManager entityManager = getEntityManager();
        try
        {
        	entityManager.getTransaction().begin();
        	Book currentBook = entityManager.find(Book.class, book.getId());
        	currentBook.setTitle(book.getTitle());
        	currentBook.setAuthor(book.getAuthor());
        	currentBook.setYear(book.getYear());
        	currentBook.setEditorial(book.getEditorial());
        	currentBook.setDateEdited(new Date());
        	entityManager.merge(currentBook);
        	entityManager.getTransaction().commit();
        }
        catch(Throwable e)
		{
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
        	entityManager.getTransaction().rollback();
        	return false;
	    }	
        finally
        {
        	if (entityManager != null)
        		entityManager.close();
		}
		return  true;
	}
	
	public boolean deleteBook(BookDto book)
	{
		EntityManager entityManager = getEntityManager();
        try
        {
        	entityManager.getTransaction().begin();
        	Book currentBook = entityManager.find(Book.class, book.getId());
        	currentBook.setTitle(book.getTitle());
        	currentBook.setAuthor(book.getAuthor());
        	currentBook.setYear(book.getYear());
        	currentBook.setEditorial(book.getEditorial());
        	currentBook.setDateDeleted(new Date());
        	currentBook.setState(STATE_INACTIVE);
        	entityManager.merge(currentBook);
        	entityManager.getTransaction().commit();
        	book.setState(currentBook.getState());
        	book.setId(null);
        }
        catch(Throwable e)
		{
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
        	entityManager.getTransaction().rollback();
        	return false;
	    }	
        finally
        {
        	if (entityManager != null)
        		entityManager.close();
		}
		return  true;
	}
}
