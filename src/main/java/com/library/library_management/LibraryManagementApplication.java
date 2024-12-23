package com.library.library_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Autowired // 2- spring will inject the created instance (bean) here
	private HelloService helloService ; // (if no @Autowired) private HelloService helloService = new HelloService();

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	public void run(String... args) throws Exception{
		System.out.println(helloService.sayHello());
	}

}