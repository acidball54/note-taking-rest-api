package com.saroj.simple_rest_api.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseNoteDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
