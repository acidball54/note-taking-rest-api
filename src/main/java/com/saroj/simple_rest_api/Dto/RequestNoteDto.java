package com.saroj.simple_rest_api.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestNoteDto {
    @NotNull(message = "Title must not be empty")
    private String title;
    @NotNull(message = "Content must not be empty")
    private String content;
}
