package org.demo.dao;

import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.demo.dto.SecurityAccessDto;
import org.demo.entities.User;
import org.demo.identity.TokenHandler;


public class LoginDao extends GeneralDao{
	
	private static final Logger logger = Logger.getLogger(LoginDao.class.getName());
	
	
	public SecurityAccessDto identityUser(String nickname, String password)
	{
		SecurityAccessDto response = new SecurityAccessDto();
		Query q = getEntityManager().createQuery("SELECT u FROM User u WHERE u.nickname = :nickname AND u.password = :password ");
        q.setParameter("nickname", nickname);
        q.setParameter("password", password);
       
        try
        {
        	User user = (User) q.getSingleResult();
        	response.setNickname(user.getNickname());
        	response.setId(user.getId());//encript(id)
        	response.setPassword(user.getPassword());//encript(password)
        	response.setJwt(TokenHandler.getInstance().createTokenForSession(response));//add jwt to db;
        }
        catch(NoResultException e)
		{
        	logger.info(logger.getName());
        	logger.warning(e.getMessage());
        	response.setNickname(nickname);
        	response.setNickname(password);
	        return response;
	    }
		
		return response;
		
	}
}
