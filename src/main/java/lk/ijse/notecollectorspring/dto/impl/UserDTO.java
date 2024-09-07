package lk.ijse.notecollectorspring.dto.impl;

import lk.ijse.notecollectorspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO {
    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePic;
    private List<NoteDTO> noteDTO;
}
