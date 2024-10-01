package lk.ijse.notecollectorspring.service;

import lk.ijse.notecollectorspring.dto.NoteStatus;
import lk.ijse.notecollectorspring.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteStatus getNote(String ID);
    List<NoteDTO> getAllNotes();
    void saveNote(NoteDTO dto);
    void updateNote(String ID, NoteDTO dto);
    void deleteNote(String ID);
}
