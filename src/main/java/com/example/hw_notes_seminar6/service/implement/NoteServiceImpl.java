package com.example.hw_notes_seminar6.service.implement;

import com.example.hw_notes_seminar6.model.Note;
import com.example.hw_notes_seminar6.repository.NoteRepository;
import com.example.hw_notes_seminar6.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    /**
     * Поле для хранения ссылки на репозиторий NoteRepository.
     */
    private final NoteRepository noteRepository;

    /**
     * Получает список всех заметок из базы данных.
     *
     * @return Список всех заметок, доступных в базе данных.
     * Возвращает пустой список, если заметок нет.
     */
    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Ищет заметку по её уникальному идентификатору.
     *
     * @param id Идентификатор заметки, которую необходимо найти.
     * @return Возвращает найденную заметку.
     * Если заметка с таким идентификатором не найдена, выбрасывает исключение.
     */
    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    /**
     * Обновляет существующую заметку на основе предоставленных данных.
     *
     * @param note Объект заметки с обновлёнными данными.
     * @return Обновлённая заметка после сохранения в базе данных.
     */
    @Override
    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());

        noteById.setTitle(note.getTitle());
        noteById.setContent(note.getContent());
        noteById.setCreationDate(note.getCreationDate());

        return noteRepository.save(noteById);
    }

    /**
     * Создаёт новую заметку.
     *
     * @param note Объект новой заметки для создания.
     * @return Созданная заметка после её сохранения в базе данных.
     */
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Удаляет заметку по её идентификатору.
     *
     * @param id Идентификатор заметки, которую необходимо удалить.
     * Производит поиск заметки по ID и, если находит, удаляет её.
     */
    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
