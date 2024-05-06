package jibek.finalproject.mapper;

import jibek.finalproject.dtos.NoteDTO;
import jibek.finalproject.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NoteMapper {

    @Mapping(target = "userId", source = "user.id")
    NoteDTO noteToNoteDto(Note note);

    @Mapping(target = "user.id", source = "userId")
    Note noteDtoToNote(NoteDTO dto);
}
