package com.devmountain.noteApp2.controllers;

import com.devmountain.noteApp2.DTO.NoteDTO;
import com.devmountain.noteApp2.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDTO noteDTO, @PathVariable Long userId) {
        noteService.addNote(noteDTO, userId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNote(@RequestBody NoteDTO noteDTO) {
        noteService.updateNoteById(noteDTO);
    }

    @GetMapping("/{noteId}")
    public Optional<NoteDTO> getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }

    @GetMapping("/user/{userId}")
    public List<NoteDTO> getNotesByUser(@PathVariable Long userId) {
        return noteService.getAllNotesByUserId(userId);
    }

}
