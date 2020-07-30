package org.demo.dao;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.demo.dto.RentalBookDto;
import org.demo.entities.RentalBook;

import static org.demo.util.Constants.*;


public class RentalBookDao extends GeneralDao
{
	
	private static final Logger logger = Logger.getLogger(RentalBookDao.class.getName());
	
	public boolean isBookRentedByBookId(Long bookId)
	{
		EntityManager entityManager = getEntityManager();
		try
        {
			Query q = getEntityManager().createQuery("SELECT COUNT(rb) FROM RentalBook rb WHERE rb.idBook = :idBook AND rb.state = :state ");
			q.setParameter("idBook", bookId);
			q.setParameter("state", STATE_RENTED);
			return (Long)q.getSingleResult() > 0L;
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
		return false;
	}
	
	public boolean rentalBook(RentalBookDto rentalBook)
	{
		EntityManager entityManager = getEntityManager();
        try
        {
        	entityManager.getTransaction().begin();
        	RentalBook newRental = entityManager.find(RentalBook.class, rentalBook.getId());
        	newRental.setIdUser(rentalBook.getIdUserSession());
        	newRental.setDateRental(new Date());
        	newRental.setState(STATE_RENTED);
        	entityManager.merge(newRental);
        	entityManager.getTransaction().commit();
        	rentalBook.setState(STATE_RENTED);
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
	
	public boolean returnBook(RentalBookDto rentalBook)
	{
		EntityManager entityManager = getEntityManager();
        try
        {
        	entityManager.getTransaction().begin();
        	RentalBook newRental = entityManager.find(RentalBook.class, rentalBook.getId());
        	newRental.setDateReturn(new Date());
        	newRental.setState(STATE_AVAILABLE);
        	entityManager.merge(newRental);
        	entityManager.getTransaction().commit();
        	rentalBook.setState(STATE_AVAILABLE);
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
}
