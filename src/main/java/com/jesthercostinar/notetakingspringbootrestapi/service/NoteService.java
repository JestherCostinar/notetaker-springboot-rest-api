package com.jesthercostinar.notetakingspringbootrestapi.service;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;

import java.util.List;

public interface NoteService {
    NoteDto createNote(NoteDto noteDto);

    List<NoteDto> getAllNotes();
}
