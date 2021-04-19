package com.thom.service;

import java.util.List;

import com.thom.entity.Note;

public interface NoteService {

	Note updateNote(Note note);

	void deleteNote(Long id);

	Note createNote(NoteDTO note);

	Note getNote(Long id);

	List<Note> getAllNote(Long id);

	Note test();

}
