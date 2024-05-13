//package jibek.finalproject.controllers;
//
//import jibek.finalproject.entities.Note;
//import jibek.finalproject.entities.User;
//import jibek.finalproject.services.NoteService;
//import jibek.finalproject.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/notes")
//public class NoteController {
//
//    @Autowired
//    private NoteService noteService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public ResponseEntity<List<Note>> getAllNotes() {
//        List<Note> noteList = noteService.getAllNotes();
//        return new ResponseEntity<>(noteList, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
//        Optional<Note> note = noteService.getNotesById(id);
//        return note.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/{userId}")
//    public ResponseEntity<Note> createNote(@PathVariable("userId") Long userId, @RequestBody Note note) {
//        Optional<User> userOptional = Optional.ofNullable(userService.getUserById(userId));
//        if (userOptional.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        User user = userOptional.get();
//        note.setUser(user);
//        note.setCreationDate(new Date());
//        note.setTitle(note.getTitle());
//        note.setDescription(note.getDescription());
//
//        Note createdNote = noteService.createNotes(note);
//        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
//        Note updatedNote = noteService.updateNotes(id, note);
//        if (updatedNote != null) {
//            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
//        noteService.deleteNotes(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}