package com.thom.service.dto;

import java.time.Instant;

public class AccountDTO {
	
	private String password;

	private String name;

	private Instant birthDay;

	
	public AccountDTO() {
		super();
	}

	public AccountDTO(String password, String name, Instant birthDay) {
		super();
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
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

	public Instant getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Instant birthDay) {
		this.birthDay = birthDay;
	}
	
	
}
