package com.saroj.simple_rest_api.service;

import com.saroj.simple_rest_api.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> get();
    Note getById(Long id);
    Note create(Note note);
    Note update(Long id, Note note);
    void delete(Long id);
}
