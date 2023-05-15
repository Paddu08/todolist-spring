package com.example.todoh2.Controller;// TodoController.java

import com.example.todoh2.Repository.TodoItemRepository.TodoItemRepository;
import com.example.todoh2.Todoitem.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
        return ResponseEntity.ok(todoItem);
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem createdTodoItem = todoItemRepository.save(todoItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem updatedTodoItem) {
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));

        todoItem.setTitle(updatedTodoItem.getTitle());
        todoItem.setDescription(updatedTodoItem.getDescription());
        todoItem.setCompleted(updatedTodoItem.isCompleted());

        TodoItem savedTodoItem = todoItemRepository.save(todoItem);
        return ResponseEntity.ok(savedTodoItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
