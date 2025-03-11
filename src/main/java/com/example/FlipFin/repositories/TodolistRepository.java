package com.example.FlipFin.repositories;

import com.example.FlipFin.model.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist, Integer> {
}
