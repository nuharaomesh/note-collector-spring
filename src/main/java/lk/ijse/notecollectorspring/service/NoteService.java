package lk.ijse.notecollectorspring.service;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO getNote();
    List<NoteDTO> getAllNotes();
    NoteDTO saveNote(NoteDTO dto);
    boolean updateNote(String ID, NoteDTO dto);
    boolean deleteNote(String ID);
}
