package org.demo.dto;

import java.io.Serializable;

public class SecurityAccessDto implements Serializable
{
	private static final long serialVersionUID = -4648674837948322592L;
	
	private String id;
	private String jwt;
	private String url;
	private String nickname;
	private String password;
	
	public SecurityAccessDto()
	{
		
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
	
	
}
