package com.jesthercostinar.notetakingspringbootrestapi.service;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;
import com.jesthercostinar.notetakingspringbootrestapi.entity.Note;

import java.util.List;

public interface NoteService {
    NoteDto createNote(NoteDto noteDto);

    List<NoteDto> getAllNotes();

    NoteDto getNote(Long id);

    NoteDto updateNote(NoteDto noteDto, Long id);
}
