package com.jesthercostinar.notetakingspringbootrestapi.repository;

import com.jesthercostinar.notetakingspringbootrestapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
