package lk.ijse.notecollectorspring.controller;

import lk.ijse.notecollectorspring.Exception.DataPersistException;
import lk.ijse.notecollectorspring.Exception.UserNotFoundException;
import lk.ijse.notecollectorspring.customStatusCode.SelectedUserErrorStatus;
import lk.ijse.notecollectorspring.dto.UserStatus;
import lk.ijse.notecollectorspring.dto.impl.UserDTO;
import lk.ijse.notecollectorspring.service.UserService;
import lk.ijse.notecollectorspring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public UserStatus getUser(@PathVariable("id") String id) {
        if (id.isEmpty() || id == null)
            return new SelectedUserErrorStatus(1, "User ID is Not Valid!");
        return userService.getUser(id);
    }

    @GetMapping()
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart ("password") String password,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("firstName") String firstName,
            @RequestPart ("email") String email,
            @RequestPart ("profilePic") MultipartFile profilePic
    ) {

        try {
            byte[] byteProPic = profilePic.getBytes();
            String base64ProPic = AppUtil.profilePicToBase64(byteProPic);

            var buildUserDTO = new UserDTO();

            String userID = AppUtil.generateUserID();
            buildUserDTO.setUserID(userID);
            buildUserDTO.setPassword(password);
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setProfilePic(base64ProPic);
            buildUserDTO.setNoteDTO(null);
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/{userID}")
    public ResponseEntity<Void> updateUser(
            @RequestPart ("password") String password,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("firstName") String firstName,
            @RequestPart ("email") String email,
            @RequestPart ("profilePic") MultipartFile profilePic,
            @PathVariable ("userID") String userID
    ) {

        try {
            byte[] byteProPic = profilePic.getBytes();
            String base64ProPic = AppUtil.profilePicToBase64(byteProPic);

            var buildUserDTO = new UserDTO();

            buildUserDTO.setUserID(userID);
            buildUserDTO.setPassword(password);
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setProfilePic(base64ProPic);
            buildUserDTO.setNoteDTO(null);
            userService.updateUser(userID, buildUserDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
