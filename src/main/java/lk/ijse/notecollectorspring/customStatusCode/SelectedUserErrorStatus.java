package lk.ijse.notecollectorspring.customStatusCode;

import lk.ijse.notecollectorspring.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SelectedUserErrorStatus implements UserStatus {
    private int statusCode;
    private String statusMessage;
}
