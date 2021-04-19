package com.thom.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thom.entity.Note;
import com.thom.repository.AccountRepository;
import com.thom.repository.NoteRepository;
import com.thom.service.NoteDTO;
import com.thom.service.NoteService;
@Service
public class NoteImpl implements NoteService{
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Note updateNote(Note note) {
		Optional<Note> noteOptional=noteRepository.findById(note.getId());
		if(noteOptional.isPresent())
		{
			note.setId(noteOptional.get().getId());
			note.setAccount(noteOptional.get().getAccount());
			note.setUpdateDate(Instant.now());
			return noteRepository.save(note);
		}
		return null;
	}

	@Override
	public void deleteNote(Long id) {
		noteRepository.deleteById(id);;
	}

	@Override
	public Note createNote(NoteDTO note) {
		Note note2 = new Note();
		note2.setNote(note.getNote());
		note2.setAccount(accountRepository.findById(note.getAccountId()).get());
		return noteRepository.save(note2);
	}

	@Override
	public Note getNote(Long id) {
		return noteRepository.findById(id).get();
	}

	@Override
	public List<Note> getAllNote(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get().getNotes();
	}

	@Override
	public Note test() {
		Note note = new Note();
		return noteRepository.save(note);
	}
	
}
