package com.saroj.simple_rest_api.mapper;

import com.saroj.simple_rest_api.Dto.RequestNoteDto;
import com.saroj.simple_rest_api.Dto.ResponseNoteDto;
import com.saroj.simple_rest_api.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);
    Note toEntity(RequestNoteDto dto);
    ResponseNoteDto toDTO(Note note);
}
