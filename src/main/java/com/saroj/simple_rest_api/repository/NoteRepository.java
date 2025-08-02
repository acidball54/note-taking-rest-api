package com.saroj.simple_rest_api.repository;

import com.saroj.simple_rest_api.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> { }
