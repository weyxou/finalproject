package jibek.finalproject.controllers;

import jibek.finalproject.dtos.ReqRes;
import jibek.finalproject.entities.Note;
import jibek.finalproject.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUsers {

    @Autowired
    private NoteRepository productRepo;

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProducts(){
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest){
        Note productToSave = new Note();
        productToSave.setTitle(productRequest.getTitle());
        return ResponseEntity.ok(productRepo.save(productToSave));
    }


    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USers alone can access this ApI only");
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminaAndUsersApi(){
        return ResponseEntity.ok("Both Admin and Users Can  access the api");
    }

//    @GetMapping("/public/email")
//    public String getCurrentUserEmail() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication); //get all details(name,email,password,roles e.t.c) of the user
//        System.out.println(authentication.getDetails()); // get remote ip
//        System.out.println(authentication.getName()); //returns the email because the email is the unique identifier
//        return authentication.getName(); // returns the email
//    }
}