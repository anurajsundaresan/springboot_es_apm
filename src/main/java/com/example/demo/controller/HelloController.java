package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

@Slf4j
public class HelloController {

    private final List<String> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return messages;
    }
    @GetMapping("/error")
    public List<String> generateErrorLog() {
    	log.error("This is a generated error- {}", this.sayHello());
    	messages.add("this is a test error message");
        return messages;
    }
    @PostMapping("/messages")
    public String addMessage(@RequestBody String message) {
        messages.add(message);
        return "Message added: " + message;
    }

    @PutMapping("/messages/{index}")
    public String updateMessage(@PathVariable int index, @RequestBody String updatedMessage) {
        if (index < messages.size()) {
            messages.set(index, updatedMessage);
            return "Message updated at index " + index + ": " + updatedMessage;
        } else {
            return "Invalid index";
        }
    }

    @DeleteMapping("/messages/{index}")
    public String deleteMessage(@PathVariable int index) {
        if (index < messages.size()) {
            String removedMessage = messages.remove(index);
            return "Message removed at index " + index + ": " + removedMessage;
        } else {
            return "Invalid index";
        }
    }
}