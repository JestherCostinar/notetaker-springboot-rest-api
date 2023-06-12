package com.jesthercostinar.notetakingspringbootrestapi.service.impl;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;
import com.jesthercostinar.notetakingspringbootrestapi.entity.Note;
import com.jesthercostinar.notetakingspringbootrestapi.repository.NoteRepository;
import com.jesthercostinar.notetakingspringbootrestapi.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;
    private ModelMapper modelMapper;

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note note = modelMapper.map(noteDto, Note.class);

        Note saveNote = noteRepository.save(note);

        NoteDto saveNoteDto = modelMapper.map(saveNote, NoteDto.class);

        return saveNoteDto;
    }
}
