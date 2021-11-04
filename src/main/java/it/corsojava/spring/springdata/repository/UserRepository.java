package it.corsojava.spring.springdata.repository;

import it.corsojava.spring.springdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByPhoto(String photo);
}
