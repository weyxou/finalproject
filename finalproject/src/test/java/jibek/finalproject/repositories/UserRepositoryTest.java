package jibek.finalproject.repositories;

import jibek.finalproject.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setEmail("jik@gmail.com");
        user.setName("jika");
        user.setPassword("jika");
        User savedUser = userRepository.save(user);
        assertEquals("jik@gmail.com", savedUser.getEmail());
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setEmail("jik@gmail.com");
        user.setName("jika");
        user.setPassword("jika");
        User savedUser = userRepository.save(user);
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("jik@gmail.com", foundUser.get().getEmail());
    }
}
