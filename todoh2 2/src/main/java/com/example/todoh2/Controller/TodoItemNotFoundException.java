package com.example.todoh2.Controller;

// TodoItemNotFoundException.java

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoItemNotFoundException extends RuntimeException {

    public TodoItemNotFoundException(Long id) {
        super("Could not find todo item with id: " + id);
    }
}
