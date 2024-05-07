package jibek.finalproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jibek.finalproject.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCRUDOperations() throws Exception {
        User newUser = new User();
        newUser.setEmail("test@example.com");
        newUser.setName("Test User");

        MvcResult createResult = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andReturn();

        assertThat(createResult.getResponse().getContentAsString()).isNotEmpty();
        User createdUser = objectMapper.readValue(createResult.getResponse().getContentAsString(), User.class);
        assertThat(createdUser.getId()).isNotNull();

        MvcResult readResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/" + createdUser.getId()))
                .andExpect(status().isOk())
                .andReturn();
        User retrievedUser = objectMapper.readValue(readResult.getResponse().getContentAsString(), User.class);
        assertThat(retrievedUser).isEqualTo(createdUser);

        createdUser.setName("Updated Test User");
        MvcResult updateResult = mockMvc.perform(MockMvcRequestBuilders.put("/users/" + createdUser.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdUser)))
                .andExpect(status().isOk())
                .andReturn();

        User updatedUser = objectMapper.readValue(updateResult.getResponse().getContentAsString(), User.class);
        assertThat(updatedUser.getName()).isEqualTo("Updated Test User");
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/" + createdUser.getId()))
                .andExpect(status().isNoContent());
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + createdUser.getId()))
                .andExpect(status().isNotFound());
    }
}
