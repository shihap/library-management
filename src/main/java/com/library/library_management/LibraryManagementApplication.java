package com.library.library_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // الكود ده هينفذ والـ Aspect هيقوم بالـ logging قبل تنفيذ الميثود
        System.out.println("Hello from the main application!");
    }
}
