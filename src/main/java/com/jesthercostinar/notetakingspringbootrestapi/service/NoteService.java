package com.jesthercostinar.notetakingspringbootrestapi.service;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;

public interface NoteService {
    NoteDto createNote(NoteDto noteDto);
}
