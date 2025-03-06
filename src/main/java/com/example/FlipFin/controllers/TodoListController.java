package com.example.FlipFin.controllers;


import com.example.FlipFin.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/todolist")
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

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        tasks.removeIf(task -> task.id().equals(taskId));

        return ResponseEntity.noContent().build();
    }
}
