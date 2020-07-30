package org.demo.identity;

import java.security.Key;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.demo.dto.SecurityAccessDto;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.util.Calendar;

public class TokenHandler 
{
	private static Logger logger = Logger.getLogger(TokenAuthentication.class.getName());
	
	private static final Key key = MacProvider.generateKey();
    private Map<String,String> tokens = new TreeMap<String, String>();
    private static TokenHandler mInstance = null;
    
    private TokenHandler()
    {
        
    }
    
    public static TokenHandler getInstance()
    {
        if(mInstance == null)
            mInstance = new TokenHandler();
        logger.info("Logger Name: " + logger.getName());
        return mInstance;
    }
    
    public String getId(String token)
    {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getId();
    }
    
    public String getSubject(String token)
    {
        try 
        {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        }
        catch (Exception e) 
        {
        	logger.warning(e.getMessage());
            return null;
        }
    }
    
    public String createTokenForSession(SecurityAccessDto session)
    {
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 2 );
        //cal.add(Calendar.MINUTE, 0);
        String token = Jwts.builder().setSubject(session.getNickname())
                .setId(session.getId())
                .setExpiration(cal.getTime())
                .signWith(SignatureAlgorithm.HS512, key).compact();
        //save user in the bd
        //tokens.put(user.getName(),token);
        return token;
    }
    
    public boolean validateToken(String token)
    {
        
        try
        {
            String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
            //if( tokens.containsKey( subject ))
            return true;
            //System.out.println("TOEKEN NO PERTENECE A NINGUN USUARIO");
            //return false;
        }
        catch (ExpiredJwtException e)
        {
        	logger.warning("EXPIRED TOKEN: " + e.getMessage());
            return false;
        }
        catch (Exception e) 
        {
        	logger.warning("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    public String getTokenForUser(String user)
    {
        if(tokens.containsKey(user))
        {
            return tokens.get(user);
        }
        return null;
    }
}
