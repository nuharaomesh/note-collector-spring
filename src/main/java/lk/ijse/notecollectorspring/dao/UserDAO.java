package lk.ijse.notecollectorspring.dao;

import lk.ijse.notecollectorspring.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {}
