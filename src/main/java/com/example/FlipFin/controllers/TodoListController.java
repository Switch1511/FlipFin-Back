package com.example.FlipFin.controllers;



import com.example.FlipFin.controllers.dto.TodolistDto;
import com.example.FlipFin.model.Todolist;
import com.example.FlipFin.repositories.TodolistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/todolist")
public class TodoListController {
    private List<Todolist> todolist = new ArrayList<>();

    @Autowired
    TodolistRepository repository;

    @GetMapping
    public ResponseEntity listTodolist() {
        List<Todolist> listTodolist = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listTodolist);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody TodolistDto dto) {
        var todolist = new Todolist();
        BeanUtils.copyProperties(dto, todolist);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(todolist));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Optional<Todolist> todolist = repository.findById(id);
        if(todolist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(todolist.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Optional<Todolist> todolist = repository.findById(id);
        if(todolist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
        }
        repository.delete(todolist.get());
        return ResponseEntity.status(HttpStatus.OK).body("Card deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody TodolistDto dto) {
        Optional<Todolist> todolist = repository.findById(id);
        if(todolist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
        }
        var todolistModel = todolist.get();
        BeanUtils.copyProperties(dto, todolistModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(todolistModel));
    }
}
