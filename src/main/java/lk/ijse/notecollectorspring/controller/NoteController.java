package lk.ijse.notecollectorspring.controller;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.service.NoteService;
import lk.ijse.notecollectorspring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    public NoteDTO getSelectedNote() {
        return null;
    }

    public List<NoteDTO> getAllNotes() {
        return null;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO dto) {
        dto.setNoteID(AppUtil.generateNoteID());
        dto.setCreateDate(String.valueOf(LocalDate.now()));
        return dto;
    }

    public String updateNote(String noteID, NoteDTO dto) {
        return "Note Updated successfully";
    }

    public String deleteNote(String noteID) {
        return "Note Deleted successfully";
    }
}
