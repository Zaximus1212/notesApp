package com.devmountain.noteApp2.services;

import com.devmountain.noteApp2.DTO.NoteDTO;
import com.devmountain.noteApp2.entities.Note;
import com.devmountain.noteApp2.entities.User;
import com.devmountain.noteApp2.repositories.NoteRepository;
import com.devmountain.noteApp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    @Transactional
    public void addNote(NoteDTO noteDTO, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Note note = new Note(noteDTO);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    @Override
    @Transactional
    public void deleteNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    @Transactional
    public void updateNoteById(NoteDTO noteDTO) {
        Optional<Note> noteOptional = noteRepository.findById(noteDTO.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDTO.getBody());
            noteRepository.saveAndFlush(note);
        });
    }

    @Override
    public List<NoteDTO> getAllNotesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NoteDTO(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<NoteDTO> getNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        if (noteOptional.isPresent()) {
            return Optional.of(new NoteDTO((noteOptional.get())));
        }
        return Optional.empty();
    }


}
