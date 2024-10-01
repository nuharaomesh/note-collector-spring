package lk.ijse.notecollectorspring.customStatusCode;

import lk.ijse.notecollectorspring.dto.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedNoteErrorCode implements NoteStatus {
    private int statusCode;
    private String statusMessage;
}
