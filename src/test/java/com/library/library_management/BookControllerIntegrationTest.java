package com.library.library_management;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest // we use it because it uses spring context (beans) in the test
@AutoConfigureMockMvc // This annotation is needed to enable MockMvc
class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // we use it simulate HTTP requests

    @MockitoBean // new annotation for @MockBean (deprecated)
    private BookService mockBookService; // here it creates a mock that is a bean , so it is in spring context , we use it because there is inner layers (services) that uses beans (@autowired) , and we cann't use mock because it is not a bean , so we use mockbean , which it is a mock and bean in the same time
     


    @Test
    void testGetBookById() throws Exception {
        // Arrange , we create some scenario for the mock bean
        when(mockBookService.findBookById(1)).thenReturn("Spring Test in Action");

        // Act and Assert (Verify response from controller)
        mockMvc.perform(get("/books/1")) // Simulate GET request to /books/1
            .andExpect(status().isOk()) // Expect HTTP 200 status
            .andExpect(content().string("Spring Test in Action")); // Expect the response body to match
    }
}

