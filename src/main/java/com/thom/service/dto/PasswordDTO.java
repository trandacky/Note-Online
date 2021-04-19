package com.thom.service.dto;

public class PasswordDTO {
	private Long accountId;
	private String password;
	
	public PasswordDTO() {
		super();
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
