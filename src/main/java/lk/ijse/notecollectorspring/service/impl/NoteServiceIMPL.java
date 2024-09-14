package lk.ijse.notecollectorspring.service.impl;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.service.NoteService;

import java.util.List;

public class NoteServiceIMPL implements NoteService {

    @Override
    public NoteDTO getNote() {
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return List.of();
    }

    @Override
    public String saveNote(NoteDTO dto) {
        return "";
    }

    @Override
    public boolean updateNote(String ID, NoteDTO dto) {
        return false;
    }

    @Override
    public boolean deleteNote(String ID) {
        return false;
    }
}
