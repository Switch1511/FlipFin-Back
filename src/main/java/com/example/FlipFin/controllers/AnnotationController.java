package com.example.FlipFin.controllers;

import com.example.FlipFin.controllers.dto.AnnotationDto;
import com.example.FlipFin.model.Annotation;
import com.example.FlipFin.repositories.AnnotationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
