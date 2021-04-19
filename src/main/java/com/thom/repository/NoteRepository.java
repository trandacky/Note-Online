package com.thom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thom.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	
}
