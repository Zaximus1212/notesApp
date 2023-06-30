package com.devmountain.noteApp2.repositories;

import com.devmountain.noteApp2.entities.Note;
import com.devmountain.noteApp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByUserEquals(User user);
}
