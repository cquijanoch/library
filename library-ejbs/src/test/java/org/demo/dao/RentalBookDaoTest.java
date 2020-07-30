package org.demo.dao;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.demo.dto.RentalBookDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RentalBookDaoTest 
{
	private RentalBookDao rentalBookDao = null;
	
	@Before
	public void setUp() {
		rentalBookDao = new RentalBookDao();
	}
	
	@After
	public void setDown() {
		rentalBookDao = null;
	}
	
	@Test
	public void TestIsBookRentedByBookId() 
	{
		try 
		{
			assertFalse(rentalBookDao.isBookRentedByBookId(1L));
			assertFalse(rentalBookDao.isBookRentedByBookId(2L));
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testRentalBook() 
	{
		
		try 
		{
			RentalBookDto rentalBook = new RentalBookDto();
			rentalBook.setId(2L);
			rentalBook.setIdUserSession("333915da-d177-11ea-87d0-0242ac130003");
			rentalBook.setIdBook(2L);
			
			assertTrue(rentalBookDao.rentalBook(rentalBook));
			assertTrue(rentalBookDao.isBookRentedByBookId(rentalBook.getId()));
			rentalBookDao.returnBook(rentalBook);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testReturnBook() 
	{
		
		try 
		{
			RentalBookDto rentalBook = new RentalBookDto();
			rentalBook.setId(2L);
			
			assertTrue(rentalBookDao.returnBook(rentalBook));
			assertFalse(rentalBookDao.isBookRentedByBookId(rentalBook.getId()));
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
