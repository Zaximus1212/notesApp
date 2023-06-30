package com.devmountain.noteApp2.entities;

import com.devmountain.noteApp2.DTO.NoteDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @JsonBackReference
    @ManyToOne
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Note() {
    }

    public Note(Long id, String body, Long userId) {
        this.id = id;
        this.body = body;
        this.userId = userId;
    }

    public Note(NoteDTO noteDTO) {
        if(noteDTO.getBody() != null){
            this.body = noteDTO.getBody();
        }
    }
}
