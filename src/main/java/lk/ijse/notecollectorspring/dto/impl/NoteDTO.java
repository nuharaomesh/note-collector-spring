package lk.ijse.notecollectorspring.dto.impl;

import lk.ijse.notecollectorspring.dto.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements NoteStatus {
    private String noteID;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String priorityLvl;
    private String userID;
}
