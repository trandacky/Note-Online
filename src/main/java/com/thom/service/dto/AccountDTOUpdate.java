package com.thom.service.dto;

import java.time.Instant;

public class AccountDTOUpdate {
	
	private Long id;

	private String name;

	private String birthDay;

	
	public AccountDTOUpdate() {
		super();
	}

	


	public String getBirthDay() {
		return birthDay;
	}




	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
