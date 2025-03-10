package com.example.FlipFin.controllers;

import com.example.FlipFin.controllers.dto.AnnotationDto;
import com.example.FlipFin.model.Annotation;
import com.example.FlipFin.repositories.AnnotationRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annotation")
public class AnnotationController {
    private List<Annotation> annotations = new ArrayList<>();

    @Autowired
    AnnotationRepository repository;

    @GetMapping
    public ResponseEntity listAnnotations() {
        List<Annotation> listAnnotations = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listAnnotations);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AnnotationDto dto) {
        var annotation = new Annotation();
        BeanUtils.copyProperties(dto, annotation);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(annotation));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Optional<Annotation> annotation = repository.findById(id);
        if(annotation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annotation not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(annotation.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Optional<Annotation> annotation = repository.findById(id);
        if(annotation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annotation not found");
        }
        repository.delete(annotation.get());
        return ResponseEntity.status(HttpStatus.OK).body("Annotation deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody AnnotationDto dto) {
        Optional<Annotation> annotation = repository.findById(id);
        if(annotation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annotation not found");
        }
        var annotationModel = annotation.get();
        BeanUtils.copyProperties(dto, annotationModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(annotationModel));
    }
}
