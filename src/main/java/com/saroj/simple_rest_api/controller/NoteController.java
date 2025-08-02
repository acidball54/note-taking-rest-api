package com.saroj.simple_rest_api.controller;

import com.saroj.simple_rest_api.entity.Note;
import com.saroj.simple_rest_api.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<Note> get() {
        return noteService.get();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id){
        return noteService.getById(id);
    }

    @PostMapping
    public Note create(@RequestBody Note note){
        return noteService.create(note);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note note){
        return noteService.update(id, note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        noteService.delete(id);
    }
}
