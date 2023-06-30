package com.devmountain.noteApp2.DTO;

import com.devmountain.noteApp2.entities.Note;
import com.devmountain.noteApp2.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;

    private Set<Note> noteSet = new HashSet<>();

    public UserDTO (User user) {
        if(user.getId() != null){
            this.id = user.getId();
        }
        if(user.getUsername() != null){
            this.username=user.getUsername();
        }
        if(user.getPassword() != null){
            this.password=user.getPassword();
        }

    }

}
