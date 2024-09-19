package lk.ijse.notecollectorspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.notecollectorspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "note")
public class Note implements SuperEntity {
    @Id
    private String noteID;
    private String noteTitle;
    private String noteDesc;
    private String createDate;
    private String priorityLvl;
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;
}
