package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private FileWorker fileWorker;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8000"));
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 2)
			fileWorker.start(args[0], args[1]);
		else
			throw new Exception("Wrong arguments");
	}
}
