package org.demo.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.demo.dto.BookDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.demo.util.Constants.*;


public class BookDaoTest 
{
	private BookDao bookDao = null;
	
	@Before
	public void setUp() {
		bookDao = new BookDao();
	}
	
	@After
	public void setDown() {
		bookDao = null;
	}
	
	@Test
	public void testInsertBook() 
	{
		try 
		{
			BookDto newBook1 = new BookDto();
			newBook1.setTitle("TitleExample1");
			newBook1.setAuthor("AuthorExample1");
			newBook1.setEditorial("EditorialExample1");
			newBook1.setYear(2011);
			
			BookDto newBook2 = new BookDto();
			newBook2.setTitle("TitleExample2");
			newBook2.setAuthor("AuthorExample2");
			newBook2.setEditorial("EditorialExample2");
			newBook2.setYear(2012);
			
			BookDto newBook3 = new BookDto();
			newBook3.setTitle("TitleExample3");
			newBook3.setAuthor("AuthorExample3");
			newBook3.setEditorial("EditorialExample3");
			newBook3.setYear(2013);
				
			int totalBeforeInsert = bookDao.getBooks().size();
			assertTrue(bookDao.insertBook(newBook1));
			assertTrue(bookDao.insertBook(newBook2));
			assertTrue(bookDao.insertBook(newBook3));
			assertEquals(bookDao.getBooks().size(), totalBeforeInsert + 3);
			
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testFindBook() 
	{
		try 
		{
			BookDto newBook4 = new BookDto();
			newBook4.setTitle("TitleExample4");
			newBook4.setAuthor("AuthorExample4");
			newBook4.setEditorial("EditorialExample4");
			newBook4.setYear(2014);
			
			assertTrue(bookDao.insertBook(newBook4));
			
			BookDto findBook1 = bookDao.getBookById(newBook4.getId());
			assertEquals(findBook1.getId(), newBook4.getId());
			assertEquals(findBook1.getAuthor(), newBook4.getAuthor());
			assertEquals(findBook1.getEditorial(), newBook4.getEditorial());
			assertEquals(findBook1.getTitle(), newBook4.getTitle());
			assertEquals(findBook1.getYear(), newBook4.getYear());
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testEditBook() 
	{
		
		try 
		{
			BookDto newBook5 = new BookDto();
			newBook5.setTitle("TitleExample5");
			newBook5.setAuthor("AuthorExample5");
			newBook5.setEditorial("EditorialExample5");
			newBook5.setYear(2015);
			assertTrue(bookDao.insertBook(newBook5));
			
			newBook5.setTitle("TitleExample6");
			newBook5.setAuthor("AuthorExample6");
			newBook5.setEditorial("EditorialExample6");
			assertTrue(bookDao.editBook(newBook5));
			
			BookDto findBook5 = bookDao.getBookById(newBook5.getId());
			
			assertEquals(newBook5.getAuthor(), findBook5.getAuthor());
			assertEquals(newBook5.getEditorial(),findBook5.getEditorial());
			assertEquals(newBook5.getTitle(), findBook5.getTitle());
			assertEquals(newBook5.getYear(), findBook5.getYear());
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testDeleteBook() 
	{
		
		try 
		{
			BookDto newBook6 = new BookDto();
			newBook6.setTitle("TitleExample6");
			newBook6.setAuthor("AuthorExample6");
			newBook6.setEditorial("EditorialExample6");
			newBook6.setYear(2016);
			assertTrue(bookDao.insertBook(newBook6));
			Long book6Id = newBook6.getId();
			
			assertTrue(bookDao.deleteBook(newBook6));
			assertNull(newBook6.getId());
			assertEquals(newBook6.getState(), STATE_INACTIVE);
			
			BookDto findBook6 = bookDao.getBookById(book6Id);
			assertEquals(findBook6.getState(), STATE_INACTIVE);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
