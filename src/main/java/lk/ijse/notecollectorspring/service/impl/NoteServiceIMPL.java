package lk.ijse.notecollectorspring.service.impl;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.service.NoteService;
import lk.ijse.notecollectorspring.util.AppUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceIMPL implements NoteService {

    private List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceIMPL() {
        noteDTOList = List.of(
                new NoteDTO("N001", "note1", "noteDesc", "20240914", "1", "1"),
                new NoteDTO("N002", "note1", "noteDesc", "20240914", "1", "1"),
                new NoteDTO("N003", "note1", "noteDesc", "20240914", "1", "3"),
                new NoteDTO("N004", "note1", "noteDesc", "20240914", "1", "2")
        );
    }

    @Override
    public NoteDTO getNote() {
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
    }

    @Override
    public NoteDTO saveNote(NoteDTO dto) {

        dto.setNoteID(AppUtil.generateNoteID());
        dto.setCreateDate(String.valueOf(LocalDate.now()));
//        noteDTOList.add(dto);
        return dto;
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
