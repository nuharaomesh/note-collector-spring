package lk.ijse.notecollectorspring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateNoteID() {
        return "NOTE-" + UUID.randomUUID();
    }
}
