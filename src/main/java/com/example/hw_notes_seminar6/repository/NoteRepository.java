package com.example.hw_notes_seminar6.repository;

import com.example.hw_notes_seminar6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс представляет собой репозиторий для сущности Note.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
