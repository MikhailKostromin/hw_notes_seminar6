package com.example.hw_notes_seminar6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Сущность заметки.
 */
@Data
@Entity
@Table(name = "notes")
public class Note {
    /**
     * Уникальный идентификатор заметки.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Заголовок заметки.
     */
    private String title;

    /**
     * Содержание заметки.
     */
    private String content;

    /**
     * Дата создания заметки
     */
    private LocalDateTime creationDate;
}
