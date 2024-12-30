package com.library.library_management.ControllerAdvice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController2 {

    @GetMapping("/say-hello/{name}")
    public String sayHello(@PathVariable String name) {
        if (name.isEmpty()) {
            throw new InvalidInputException("Name cannot be empty.");
        }
        return "Hello, " + name + "!";
    }
}
