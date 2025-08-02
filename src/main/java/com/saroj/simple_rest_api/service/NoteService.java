package com.saroj.simple_rest_api.service;

import com.saroj.simple_rest_api.Dto.RequestNoteDto;
import com.saroj.simple_rest_api.Dto.ResponseNoteDto;
import com.saroj.simple_rest_api.entity.Note;

import java.util.List;

public interface NoteService {
    List<ResponseNoteDto> get();
    ResponseNoteDto getById(Long id);
    ResponseNoteDto create(RequestNoteDto noteDto);
    ResponseNoteDto update(Long id, RequestNoteDto noteDto);
    void delete(Long id);
}
