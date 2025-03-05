package com.example.FlipFin.controllers;


import com.example.FlipFin.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/teste")
public class TodoListController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Task>> listarTasks() {
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        tasks.add(task);
    }
}
