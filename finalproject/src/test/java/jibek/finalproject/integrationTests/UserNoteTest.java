package jibek.finalproject.integrationTests;

import jibek.finalproject.entities.Note;
import jibek.finalproject.entities.User;
import jibek.finalproject.repositories.NoteRepository;
import jibek.finalproject.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserNoteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void testUserNoteIntegration() throws Exception {
        // Создаем пользователя
        User user = new User();
        user.setEmail("ai1@example.com");
        user.setName("ai");
        user.setPassword("ai");
        userRepository.save(user);

        // Создаем заметку
        Note note = new Note();
        note.setTitle("im ai");
        note.setDescription("hiii");
        note.setCreationDate(new Date());
        note.setUser(user);
        noteRepository.save(note);

        // Получаем идентификатор пользователя
        Long userId = user.getId();

        // Отправляем запрос на получение заметок пользователя
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/notes/" + userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Проверяем успешность получения заметок пользователя
        String content = result.getResponse().getContentAsString();
        assertThat(content).contains("im ai");
        assertThat(content).contains("hiii");
    }
}
