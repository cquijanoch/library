package org.demo.identity;

import java.util.logging.Logger;

public class TokenAuthentication 
{
	private static Logger logger = Logger.getLogger(TokenAuthentication.class.getName());

	public boolean isValidAuthentication(String tokenRequest) 
	{
		logger.info("Logger Name: " + logger.getName());
		boolean result = TokenHandler.getInstance().validateToken(tokenRequest);
		StringBuilder msg = new StringBuilder();
	    msg.append("Token request: ")
	    .append(tokenRequest)
	    .append(" Result: ")
	    .append(result);
		logger.warning(msg.toString());
		return result;
	}
}
