package org.demo.business;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface LoginBusiness {

	public Map<String,Object> identityUser(String nickname,String password);
	public boolean isValidAuthentication(String tokenRequest);

}
