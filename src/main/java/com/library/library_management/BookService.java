package com.library.library_management;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public String findBookById(int id) {
        if (id == 1) {
            return "Mockito in Action";
        }
        return "Unknown Book";
    }
}
