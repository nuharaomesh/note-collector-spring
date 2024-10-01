package lk.ijse.notecollectorspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.notecollectorspring.Exception.NoteNotFoundException;
import lk.ijse.notecollectorspring.Exception.UserNotFoundException;
import lk.ijse.notecollectorspring.customStatusCode.SelectedNoteErrorCode;
import lk.ijse.notecollectorspring.dao.NoteDAO;
import lk.ijse.notecollectorspring.dto.NoteStatus;
import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.entity.impl.Note;
import lk.ijse.notecollectorspring.service.NoteService;
import lk.ijse.notecollectorspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public NoteStatus getNote(String ID) {
        if (noteDAO.existsById(ID)) {
            Note selectedUser = noteDAO.getReferenceById(ID);
            return mapping.toNoteDTO(selectedUser);
        } else {
            return new SelectedNoteErrorCode(2, "");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        List<Note> noteList = noteDAO.findAll();
        return mapping.getNoteDTOList(noteList);
    }

    @Override
    public void saveNote(NoteDTO dto) {
        noteDAO.save(mapping.toNoteEntity(dto));
    }

    @Override
    public void updateNote(String ID, NoteDTO dto) {
        Optional<Note> tmpNote = noteDAO.findById(ID);
        if (!tmpNote.isPresent())
            throw new NoteNotFoundException();
        else
            tmpNote.get().setNoteTitle(dto.getNoteTitle());
            tmpNote.get().setNoteDesc(dto.getNoteDesc());
            tmpNote.get().setCreateDate(dto.getCreateDate());
            tmpNote.get().setPriorityLvl(dto.getPriorityLvl());
    }

    @Override
    public void deleteNote(String ID) {
        Optional<Note> tmpNote = noteDAO.findById(ID);
        if (!tmpNote.isPresent()) {
            throw new UserNotFoundException("User Not Found!");
        } else {
            noteDAO.deleteById(ID);
        }
    }
}
