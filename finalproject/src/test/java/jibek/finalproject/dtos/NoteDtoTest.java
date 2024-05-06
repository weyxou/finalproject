package jibek.finalproject.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class NoteDtoTest {

    @Test
    public void testCreateNoteDTO() {
        Date dateMock = mock(Date.class);

        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(1L);
        noteDTO.setTitle("note 2");
        noteDTO.setDescription("lessons");
        noteDTO.setDate(dateMock);

        assertNotNull(noteDTO);
        assertEquals(1L, noteDTO.getId());
        assertEquals("note 2", noteDTO.getTitle());
        assertEquals("lessons", noteDTO.getDescription());
        assertEquals(dateMock, noteDTO.getDate());
    }
}
