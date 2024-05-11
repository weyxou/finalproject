package jibek.finalproject.repositories;

import jibek.finalproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    boolean existsById(Long id);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
