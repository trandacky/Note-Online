package com.thom.service;

public class NoteDTO {
	
	private Long accountId;
	
	private String note;

	

	public NoteDTO() {
		super();
	}

	public NoteDTO(Long accountId, String note) {
		super();
		this.accountId = accountId;
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	
}
