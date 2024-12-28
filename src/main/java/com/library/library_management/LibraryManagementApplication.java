package com.library.library_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Value("${app.name}") //this will assign the value of this constant in application.properties
	private String appName ;

	@Value("${app.version}") //this will assign the value of this constant in application.properties
	private String appVersion ;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	public void run(String... args) throws Exception{
		System.out.println("Welcome to " + appName + " - Version: " + appVersion);
	}

}