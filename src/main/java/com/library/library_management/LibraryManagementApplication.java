package com.library.library_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    //will use it to create the logs for this class in the console and log file (logs/book.log)
    private static final Logger log = LoggerFactory.getLogger(LibraryManagementApplication.class);

    //the log pattern in logback.xml file , it can also written in properties file


	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}


	public void run(String... args) throws Exception{
        log.trace("This is a trace message.");
        log.debug("This is a debug message.");
		log.info("This is an info message.");
        log.warn("This is a warn message.");
        log.error("This is an error message.");
	}

}