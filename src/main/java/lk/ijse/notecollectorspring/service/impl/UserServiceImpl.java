package lk.ijse.notecollectorspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecollectorspring.Exception.UserNotFoundException;
import lk.ijse.notecollectorspring.customStatusCode.SelectedUserErrorStatus;
import lk.ijse.notecollectorspring.dao.UserDAO;
import lk.ijse.notecollectorspring.dto.UserStatus;
import lk.ijse.notecollectorspring.dto.impl.UserDTO;
import lk.ijse.notecollectorspring.entity.impl.User;
import lk.ijse.notecollectorspring.service.UserService;
import lk.ijse.notecollectorspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;


    @Override
    public UserStatus getUser(String id) {
        if (userDAO.existsById(id)) {
            User selectedUser = userDAO.getReferenceById(id);
            return mapping.toUserDTO(selectedUser);
        } else {
            return new SelectedUserErrorStatus(2, "");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userDAO.findAll();
        return mapping.getUserDTOList(userList);
    }

    @Override
    public void saveUser(UserDTO dto) {
        userDAO.save(mapping.toUserEntity(dto));
    }

    @Override
    public void updateUser(String ID, UserDTO dto) {
        Optional<User> tmpUser = userDAO.findById(ID);
        if (!tmpUser.isPresent())
            throw new UserNotFoundException();
        else
            tmpUser.get().setPassword(dto.getPassword());
            tmpUser.get().setFirstName(dto.getFirstName());
            tmpUser.get().setLastName(dto.getLastName());
            tmpUser.get().setEmail(dto.getEmail());
            tmpUser.get().setProfilePic(dto.getProfilePic());
    }

    @Override
    public void deleteUser(String ID) {
        Optional<User> tmpUser = userDAO.findById(ID);
        if (!tmpUser.isPresent()) {
            throw new UserNotFoundException("Note Not Found!");
        } else {
            userDAO.deleteById(ID);
        }
    }
}
