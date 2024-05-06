package jibek.finalproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jibek.finalproject.dtos.NoteDTO;
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

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCRUDOperations() throws Exception {

        NoteDTO newNote = new NoteDTO();
        newNote.setTitle("Test Note");
        newNote.setDescription("This is a test note");
        newNote.setDate(new Date());

        MvcResult createResult = mockMvc.perform(MockMvcRequestBuilders.post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newNote)))
                .andExpect(status().isCreated())
                .andReturn();

        NoteDTO createdNote = objectMapper.readValue(createResult.getResponse().getContentAsString(), NoteDTO.class);
        assertThat(createdNote.getId()).isNotNull();

        MvcResult readResult = mockMvc.perform(MockMvcRequestBuilders.get("/notes/" + createdNote.getId()))
                .andExpect(status().isOk())
                .andReturn();

        NoteDTO retrievedNote = objectMapper.readValue(readResult.getResponse().getContentAsString(), NoteDTO.class);
        assertThat(retrievedNote).isEqualTo(createdNote);

        createdNote.setTitle("Updated Test Note");
        MvcResult updateResult = mockMvc.perform(MockMvcRequestBuilders.put("/notes/" + createdNote.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createdNote)))
                .andExpect(status().isOk())
                .andReturn();

        NoteDTO updatedNote = objectMapper.readValue(updateResult.getResponse().getContentAsString(), NoteDTO.class);
        assertThat(updatedNote.getTitle()).isEqualTo("Updated Test Note");

        mockMvc.perform(MockMvcRequestBuilders.delete("/notes/" + createdNote.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(MockMvcRequestBuilders.get("/notes/" + createdNote.getId()))
                .andExpect(status().isNotFound());
    }
}
