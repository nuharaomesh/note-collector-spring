package lk.ijse.notecollectorspring.controller;

import lk.ijse.notecollectorspring.dto.impl.NoteDTO;
import lk.ijse.notecollectorspring.service.NoteService;
import lk.ijse.notecollectorspring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO dto) {
        return noteService.saveNote(dto);
    }

    public String updateNote(String noteID, NoteDTO dto) {
        return "Note Updated successfully";
    }

    public String deleteNote(String noteID) {
        return "Note Deleted successfully";
    }
}
