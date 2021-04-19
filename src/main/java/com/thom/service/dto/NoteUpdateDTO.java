package com.thom.service.dto;

public class NoteUpdateDTO {
	private Long noteId;

	private String note;

	public NoteUpdateDTO() {
		super();
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
