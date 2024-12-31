package com.library.library_management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        if (id == 1) {
            return "JUnit in Action";
        }
        return "Unknown Book";
    }
}
