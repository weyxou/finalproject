//package jibek.finalproject.mapper;
//
//import jibek.finalproject.dtos.NoteDTO;
//import jibek.finalproject.entities.Note;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper
//public interface NoteMapper {
//
//    @Mapping(source = "user.id", target = "userId")
//    NoteDTO noteToNoteDTO(Note note);
//
//    @Mapping(source = "userId", target = "user.id")
//    Note noteDTOToNote(NoteDTO noteDTO);
//}
