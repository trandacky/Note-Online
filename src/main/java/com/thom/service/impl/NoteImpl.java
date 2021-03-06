package com.thom.service.impl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thom.entity.Note;
import com.thom.repository.AccountRepository;
import com.thom.repository.NoteRepository;
import com.thom.service.NoteDTO;
import com.thom.service.NoteService;
import com.thom.service.dto.NoteUpdateDTO;
@Service
public class NoteImpl implements NoteService{
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Note updateNote(NoteUpdateDTO noteDTO) {
		Optional<Note> noteOptional=noteRepository.findById(noteDTO.getNoteId());
		if(noteOptional.isPresent())
		{
			Note note= noteOptional.get();
			note.setNote(noteDTO.getNote());
			note.setUpdateDate(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant());
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
		List<Note> notes=accountRepository.findById(id).get().getNotes();
		return notes.stream().sorted(Comparator.comparing(Note::getUpdateDate).reversed()).collect(Collectors.toList());
	}

	@Override
	public Note test() {
		Note note = new Note();
		return noteRepository.save(note);
	}

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	}
	
}
