package com.library.library_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

}

/*
 * to access the H2 console : http://localhost:8080/h2-console
 * 
 * 
 * sql for some books:
 * 
INSERT INTO BOOK (ID,AUTHOR, TITLE) VALUES 
(1,'Harper Lee', 'To Kill a Mockingbird'),
(2,'George Orwell', '1984'),
(3,'J.D. Salinger', 'The Catcher in the Rye')
 * 
*/

