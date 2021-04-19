package com.thom.service.dto;

import java.time.Instant;

public class AccountDTOUpdate {
	
	private Long id;

	private String name;

	private Instant birthDay;

	
	public AccountDTOUpdate() {
		super();
	}

	

	public AccountDTOUpdate(Long id, String name, Instant birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
