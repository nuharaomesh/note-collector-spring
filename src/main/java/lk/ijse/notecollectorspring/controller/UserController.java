package lk.ijse.notecollectorspring.controller;

import lk.ijse.notecollectorspring.dto.impl.UserDTO;
import lk.ijse.notecollectorspring.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart ("password") String password,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("firstName") String firstName,
            @RequestPart ("email") String email,
            @RequestPart ("profilePic") String profilePic
    ) {
        System.out.println("awa1");

        var base64ProPic = AppUtil.profilePicToBase64(profilePic);
        String userID = AppUtil.generateUserID();

        System.out.println("awa2");

        var buildUserDTO = new UserDTO();

        System.out.println("awa3");

        buildUserDTO.setUserID(userID);
        buildUserDTO.setPassword(password);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setProfilePic(base64ProPic);
        buildUserDTO.setNoteDTO(null);

        System.out.println("awa4");
        return buildUserDTO;
    }
}
