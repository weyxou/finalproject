package jibek.finalproject.repositories;

import jibek.finalproject.entities.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void testSaveNote() {
        Note note = new Note();
        note.setTitle("note1");
        Note savedNote = noteRepository.save(note);
        assertEquals("note1", savedNote.getTitle()); // Проверяем, что заголовок сохраненной заметки равен "note1"
    }

    @Test
    public void testFindById() {
        Note note = new Note();
        note.setTitle("note1");
        Note savedNote = noteRepository.save(note);
        Optional<Note> foundNote = noteRepository.findById(savedNote.getId());
        assertTrue(foundNote.isPresent()); // Проверяем, что заметка была найдена
        assertEquals("note1", foundNote.get().getTitle()); // Проверяем, что заголовок найденной заметки равен "Gold Necklace"
    }
}
