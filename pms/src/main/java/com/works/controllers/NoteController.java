package com.works.controllers;

import com.works.props.Notes;
import com.works.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    Notes notes=new Notes();
    @GetMapping("/note")
    public String note(){
        return "note";
    }
    @PostMapping("/addNote")
    public String addNote(Notes notes){
        NoteService service=new NoteService();
        int status = service.addNote(notes);
        if (status >0){
            return "/note";
        }
        return "/note";
    }
}
