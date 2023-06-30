package com.devmountain.noteApp2.services;

import com.devmountain.noteApp2.DTO.NoteDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDTO noteDTO, Long userId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDTO noteDTO);

    List<NoteDTO> getAllNotesByUserId(Long userId);

    Optional<NoteDTO> getNoteById(Long noteId);
}
