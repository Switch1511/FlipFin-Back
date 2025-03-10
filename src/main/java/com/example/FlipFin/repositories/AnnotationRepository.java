package com.example.FlipFin.repositories;


import com.example.FlipFin.model.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer> {
}
