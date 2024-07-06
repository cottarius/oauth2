package ru.cotarius.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cotarius.oauth2.enity.Note;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
}
