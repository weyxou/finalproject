//package jibek.finalproject.services;
//
//import jibek.finalproject.entities.Note;
//import jibek.finalproject.entities.User;
//import jibek.finalproject.repositories.NoteRepository;
//import jibek.finalproject.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class NoteService {
//
//    @Autowired
//    private NoteRepository noteRepository;
//
//    public List<Note> getAllNotes() {
//        return noteRepository.findAll();
//    }
//
//    public Optional<Note> getNotesById(Long id) {
//        return noteRepository.findById(id);
//    }
//
//    public Note createNotes(Note notes) {
//        return noteRepository.save(notes);
//    }
//
//    public Note updateNotes(Long id, Note updatedNotes) {
//        if (noteRepository.existsById(id)) {
//            updatedNotes.setId(id);
//            return noteRepository.save(updatedNotes);
//        }
//        return null;
//    }
//
//
//    public void deleteNotes(Long id) {
//        noteRepository.deleteById(id);
//    }
//}