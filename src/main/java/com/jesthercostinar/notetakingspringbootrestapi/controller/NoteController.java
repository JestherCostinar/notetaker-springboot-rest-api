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

    @GetMapping("{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id) {
        NoteDto note = noteService.getNote(id);

        return ResponseEntity.ok(note);
    }

    @PutMapping("{id}")
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto noteDto,
                                              @PathVariable Long id) {
        NoteDto updatedNote = noteService.updateNote(noteDto, id);

        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);

        return ResponseEntity.ok("Note with id: " + id + " has been deleted");
    }

    @PatchMapping("{id}/hide")
    public ResponseEntity<NoteDto> hideNote(@PathVariable Long id) {
        NoteDto note = noteService.isNoteHidden(id);

        return ResponseEntity.ok(note);
    }

    @PatchMapping("{id}/unhide")
    public ResponseEntity<NoteDto> unhideNote(@PathVariable Long id) {
        NoteDto note = noteService.isNoteUnHide(id);

        return ResponseEntity.ok(note);
    }
}
