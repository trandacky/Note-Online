package com.thom.service;

import java.util.List;

import com.thom.entity.Note;
import com.thom.service.dto.NoteUpdateDTO;

public interface NoteService {

	Note updateNote(NoteUpdateDTO note);

	void deleteNote(Long id);

	Note createNote(NoteDTO note);

	Note getNote(Long id);

	List<Note> getAllNote(Long id);

	Note test();

}
