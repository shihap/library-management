package com.library.library_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class) // a header flag for mockito , declares that we using it
class BookControllerMockitoTest {

    @Mock // create a fake instance that we modify its behaviour , it is not a bean 
    private BookService mockBookService;

    @InjectMocks // we use it instead of @autowired , because the mocks is not beans 
    private BookController bookController;

    @Test
    void testGetBookById() {
        // Arrange , we create some scenario for the mock
        when(mockBookService.findBookById(1)).thenReturn("Mockito in Action");

        // Act
        String result = bookController.getBookById(1);

        // Assert
        assertEquals("Mockito in Action", result);

        // Verify that the mock called its function
        verify(mockBookService).findBookById(1);
    }
}
