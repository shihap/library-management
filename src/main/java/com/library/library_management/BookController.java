package com.library.library_management;

import com.library.library_management.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Spring in Action");
        book1.setAuthor("Craig Walls");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Clean Code");
        book2.setAuthor("Robert C. Martin");

        return ResponseEntity.ok(Arrays.asList(book1, book2));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello test");
    }


}
