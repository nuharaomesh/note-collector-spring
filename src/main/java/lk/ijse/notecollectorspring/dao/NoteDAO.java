package lk.ijse.notecollectorspring.dao;

import lk.ijse.notecollectorspring.entity.impl.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<Note, String> {}
