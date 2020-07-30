package org.demo.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.demo.dto.SecurityAccessDto;
import org.junit.Assert;
import org.junit.Test;

public class LoginDaoTest 
{
	
	@Test
	public void testLoginResquestAcepted() {
		try 
		{
			LoginDao loginDao = new LoginDao();
			SecurityAccessDto session = loginDao.identityUser("testuser1", "encripteduser1");
			assertTrue(session.getId() != null && !session.getId().trim().isEmpty());
			assertTrue(session.getJwt() != null && !session.getJwt().trim().isEmpty());
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLoginResquestRecused() {
		try 
		{
			LoginDao loginDao = new LoginDao();
			SecurityAccessDto session = loginDao.identityUser("testuser2", "encripteduser2");
			assertTrue(session.getId() == null || session.getId().trim().isEmpty());
			assertTrue(session.getId() == null || session.getId().trim().isEmpty());
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
