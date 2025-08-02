package com.saroj.simple_rest_api.service;

import com.saroj.simple_rest_api.Dto.RequestNoteDto;
import com.saroj.simple_rest_api.Dto.ResponseNoteDto;
import com.saroj.simple_rest_api.entity.Note;
import com.saroj.simple_rest_api.mapper.NoteMapper;
import com.saroj.simple_rest_api.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Override
    public List<ResponseNoteDto> get() {
        return noteRepository.findAll().stream()
                .map(noteMapper::toDTO)
                .toList();
    }

    @Override
    public ResponseNoteDto getById(Long id) {
        Note note =  noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found with id: " + id));
        return noteMapper.toDTO(note);
    }

    @Override
    public ResponseNoteDto create(RequestNoteDto noteDto) {
        Note note = noteMapper.toEntity(noteDto);
        return noteMapper.toDTO(noteRepository.save(note));
    }

    @Override
    public ResponseNoteDto update(Long id, RequestNoteDto noteDto) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        existingNote.setTitle(noteDto.getTitle());
        existingNote.setContent(noteDto.getContent());
        return noteMapper.toDTO(noteRepository.save(existingNote));
    }

    @Override
    public void delete(Long id) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(existingNote);
    }
}
