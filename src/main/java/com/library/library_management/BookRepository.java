package com.library.library_management;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String findBookNameById(int id) {
        if (id == 1) {
            return "Spring Test in Action";
        }
        return "Unknown Book";
    }
}

