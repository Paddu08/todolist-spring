package com.example.todoh2.Repository.TodoItemRepository;

// TodoItemRepository.java

import com.example.todoh2.Todoitem.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
