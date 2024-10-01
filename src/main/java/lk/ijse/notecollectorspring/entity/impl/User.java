package lk.ijse.notecollectorspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.notecollectorspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class User implements SuperEntity {
    @Id
    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @OneToMany(mappedBy = "user")
    private List<Note> noteDTO;
}
