package ru.cotarius.oauth2.controller;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cotarius.oauth2.enity.Note;
import ru.cotarius.oauth2.repository.NoteRepo;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepo noteRepo;

    @GetMapping("/notes")
    public String notes(Model model){
        List<Note> notes = noteRepo.findAll();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @PostMapping("/addnote")
    public String addNote(String title, String note){
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setNote(note);
        noteRepo.save(newNote);
        return "redirect:/notes";
    }
}
