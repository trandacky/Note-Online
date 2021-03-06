package com.thom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thom.entity.Note;
import com.thom.service.NoteDTO;
import com.thom.service.NoteService;
import com.thom.service.dto.NoteUpdateDTO;

@RestController
@RequestMapping(value="/api/note")
public class NoteController {
	@Autowired
	private NoteService noteService;

	@GetMapping("get-all/{id}")
	public List<Note> getAllNote(@PathVariable Long id) {
		return noteService.getAllNote(id);
	}
	@GetMapping("get-all/")
	public List<Note> getAll() {
		return noteService.getAll();
	}

	@GetMapping("get-note/{id}")
	public Note getNote(@PathVariable Long id) {
		return noteService.getNote(id);
	}

	@PostMapping("create-note")
	public Note createNote(@RequestBody NoteDTO note) {
		return noteService.createNote(note);
	}

	@DeleteMapping("delete-note/{id}")
	public void deleteNote(@PathVariable Long id) {
		noteService.deleteNote(id);
	}

	@PutMapping("update-note")
	public Note updateNote(@RequestBody NoteUpdateDTO note) {
		return noteService.updateNote(note);
	}
	@GetMapping("/test")
	public Note abc()
	{
		return noteService.test();
	}
}
