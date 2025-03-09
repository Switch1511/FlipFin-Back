package com.example.FlipFin.controllers;

import com.example.FlipFin.domain.Annotation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/annotation")
public class AnnotationController {
    private List<Annotation> annotations = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Annotation>> listAnnotations() {
        return ResponseEntity.ok(annotations);
    }

    @PostMapping
    public void createTask(@RequestBody Annotation task) {
        annotations.add(task);
    }

    @DeleteMapping("/{annotationId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long annotationId) {
        annotations.removeIf(task -> task.id().equals(annotationId));
        return ResponseEntity.noContent().build();
    }
}
