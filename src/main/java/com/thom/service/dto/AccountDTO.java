package com.thom.service.dto;

import java.time.Instant;

public class AccountDTO {
	
	private String password;

	private String name;

	private String birthDay;

	
	public AccountDTO() {
		super();
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	
	
	
}
