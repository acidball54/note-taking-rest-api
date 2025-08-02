package com.saroj.simple_rest_api.service;

import com.saroj.simple_rest_api.entity.Note;
import com.saroj.simple_rest_api.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;

    @Override
    public List<Note> get() {
        return noteRepository.findAll();
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found with id: " + id));
    }

    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note update(Long id, Note note) {
        Note existingNote = getById(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return noteRepository.save(existingNote);
    }

    @Override
    public void delete(Long id) {
        Note existingNote = getById(id);
        noteRepository.delete(existingNote);
    }
}
