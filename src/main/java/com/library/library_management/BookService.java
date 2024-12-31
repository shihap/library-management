package com.library.library_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String findBookById(int id) {
        return bookRepository.findBookNameById(id);
    }
}
