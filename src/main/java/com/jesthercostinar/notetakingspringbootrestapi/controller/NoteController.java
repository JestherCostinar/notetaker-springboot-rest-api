package com.jesthercostinar.notetakingspringbootrestapi.controller;

import com.jesthercostinar.notetakingspringbootrestapi.dto.NoteDto;
import com.jesthercostinar.notetakingspringbootrestapi.entity.Note;
import com.jesthercostinar.notetakingspringbootrestapi.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) {
        NoteDto saveNote = noteService.createNote(noteDto);

        return new ResponseEntity<>(saveNote, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<NoteDto> notes = noteService.getAllNotes();

        return ResponseEntity.ok(notes);
    }
}
