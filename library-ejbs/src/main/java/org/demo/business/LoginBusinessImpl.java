package org.demo.business;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.demo.dao.LoginDao;
import org.demo.dto.SecurityAccessDto;
import org.demo.identity.TokenAuthentication;
import org.demo.identity.TokenHandler;

@Stateless
public class LoginBusinessImpl implements LoginBusiness 
{

	private LoginDao loginDao;

	public LoginDao getService() 
	{
		return this.loginDao;
	}

	@PostConstruct
	public void initialize() 
	{
		this.loginDao = new LoginDao();
	}

	@Override
	public Map<String, Object> identityUser(String nickname, String password) 
	{
		SecurityAccessDto session = loginDao.identityUser(nickname, password);
		if (session.getId().isEmpty()) 
			throw new NullPointerException();

		Map<String, Object> response = new HashMap<String, Object>();
		session.setJwt(TokenHandler.getInstance().createTokenForSession(session));
		response.put("permission", session);
		return response;
	}

	@Override
	public boolean isValidAuthentication(String tokenRequest)
	{
		return (new TokenAuthentication()).isValidAuthentication(tokenRequest);
	}

}
