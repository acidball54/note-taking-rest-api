package com.saroj.simple_rest_api.controller;

import com.saroj.simple_rest_api.Dto.RequestNoteDto;
import com.saroj.simple_rest_api.Dto.ResponseNoteDto;
import com.saroj.simple_rest_api.entity.Note;
import com.saroj.simple_rest_api.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<ResponseNoteDto>> get() {
        return ResponseEntity.ok(noteService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseNoteDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(noteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseNoteDto> create(@RequestBody RequestNoteDto noteDto){
        ResponseNoteDto note = noteService.create(noteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseNoteDto> update(@PathVariable Long id, @RequestBody RequestNoteDto noteDto){
        return ResponseEntity.ok(noteService.update(id, noteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
