package org.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = -7250234396452258822L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "password")
	private String password;

	public String getId() {
		return id;
	}

	public User() 
	{
		
	}
	
	public User(String nickname, String password) {
		super();
		this.nickname = nickname;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
