package jibek.finalproject.controllers;

import jibek.finalproject.dtos.ReqRes;
import jibek.finalproject.entities.Note;
import jibek.finalproject.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
public class AdminUsers {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/notes/savenotes")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes noteRequest){
        Note NewNote = new Note();
        NewNote.setTitle(noteRequest.getTitle());
        NewNote.setDescription(noteRequest.getDescription());
        NewNote.setCreationDate(new Date());

        return ResponseEntity.ok(noteRepository.save(NewNote));
    }
    @GetMapping("/notes/savenotes")
    public ResponseEntity<Object> getNotes(){
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminaAndUsersApi(){
        return ResponseEntity.ok("Both Admin and Users Can access the api");
    }

}