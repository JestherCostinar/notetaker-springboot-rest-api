package com.jesthercostinar.notetakingspringbootrestapi.service.impl;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;
import com.jesthercostinar.notetakingspringbootrestapi.entity.Note;
import com.jesthercostinar.notetakingspringbootrestapi.exception.ResourceNotFoundException;
import com.jesthercostinar.notetakingspringbootrestapi.repository.NoteRepository;
import com.jesthercostinar.notetakingspringbootrestapi.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAll();

        return notes.stream().map(note -> modelMapper.map(note, NoteDto.class)).collect(Collectors.toList());
    }

    @Override
    public NoteDto getNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note of id: " + id + " is not found"));

        return modelMapper.map(note, NoteDto.class);
    }

    @Override
    public NoteDto updateNote(NoteDto notedto, Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note with id of " + id + " is not found"));

        note.setTitle(notedto.getTitle());
        note.setBody(notedto.getBody());
        note.setHidden(notedto.isHidden());

        Note updatedNote = noteRepository.save(note);

        return modelMapper.map(updatedNote, NoteDto.class);
    }

    @Override
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        noteRepository.deleteById(note.getId());
    }
}
