package jibek.finalproject.mapper;

import javax.annotation.processing.Generated;
import jibek.finalproject.dtos.NoteDTO;
import jibek.finalproject.entities.Note;
import jibek.finalproject.entities.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T17:31:11+0600",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDTO noteToNoteDTO(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();

        noteDTO.setUserId( noteUserId( note ) );

        return noteDTO;
    }

    @Override
    public Note noteDTOToNote(NoteDTO noteDTO) {
        if ( noteDTO == null ) {
            return null;
        }

        Note note = new Note();

        note.setUser( noteDTOToUser( noteDTO ) );

        return note;
    }

    private Long noteUserId(Note note) {
        User user = note.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    protected User noteDTOToUser(NoteDTO noteDTO) {
        if ( noteDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( noteDTO.getUserId() );

        return user;
    }
}
