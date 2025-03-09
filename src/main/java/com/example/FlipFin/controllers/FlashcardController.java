package com.example.FlipFin.controllers;

import com.example.FlipFin.domain.Annotation;
import com.example.FlipFin.domain.Flashcard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {
    private List<Flashcard> flashcards = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Flashcard>> listAnnotations() {
        return ResponseEntity.ok(flashcards);
    }

    @PostMapping
    public void createTask(@RequestBody Flashcard task) {
        flashcards.add(task);
    }

    @DeleteMapping("/{flashcardId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long flashcardId) {
        flashcards.removeIf(task -> task.id().equals(flashcardId));
        return ResponseEntity.noContent().build();
    }
}
