package com.library.library_management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BookControllerUnitTest {

    @Test
    void testGetBookById() {
        // Arrange , we can't use @autowired with junit because he not using spring beans 
        BookController bookController = new BookController();

        // Act
        String result = bookController.getBookById(1);

        // Assert
        assertEquals("JUnit in Action", result);
    }
}
