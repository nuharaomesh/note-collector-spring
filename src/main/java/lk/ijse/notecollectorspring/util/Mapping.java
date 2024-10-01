package lk.ijse.notecollectorspring.util;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.dto.impl.UserDTO;
import lk.ijse.notecollectorspring.entity.impl.Note;
import lk.ijse.notecollectorspring.entity.impl.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public User toUserEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserDTO toUserDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    public Note toNoteEntity(NoteDTO dto) {
        return modelMapper.map(dto, Note.class);
    }

    public NoteDTO toNoteDTO(Note entity) {
        return modelMapper.map(entity, NoteDTO.class);
    }

    public List<UserDTO> getUserDTOList(List<User> userEntitiesList) {
        return modelMapper.map(userEntitiesList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public List<NoteDTO> getNoteDTOList(List<Note> noteEntitiesList) {
        return modelMapper.map(noteEntitiesList, new TypeToken<List<NoteDTO>>(){}.getType());
    }
}
