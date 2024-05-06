package jibek.finalproject.bootstrap;

import jakarta.annotation.PostConstruct;
import jibek.finalproject.repositories.NoteRepository;
import jibek.finalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoad {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private NoteRepository noteRepository;

    @PostConstruct
    public void loadTestData() {
    }
}
