package ru.mirea.example11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example11Application {

	// Для проверки работы нужно перейти на http://localhost:8080/actuator
	public static void main(String[] args) {
		SpringApplication.run(Example11Application.class, args);
	}

}
