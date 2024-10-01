package lk.ijse.notecollectorspring.service;

import lk.ijse.notecollectorspring.dto.UserStatus;
import lk.ijse.notecollectorspring.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserStatus getUser(String id);
    List<UserDTO> getAllUsers();
    void saveUser(UserDTO dto);
    void updateUser(String ID, UserDTO dto);
    void deleteUser(String ID);
}
