package com.devmountain.noteApp2.DTO;

import com.devmountain.noteApp2.entities.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long Id;
    private String body;
    private UserDTO userDTO;

    public NoteDTO(Note note) {
        if(note.getId() != null){
            this.Id= note.getId();
        }
        if(note.getBody() != null){
            this.body= note.getBody();
        }
    }


}
