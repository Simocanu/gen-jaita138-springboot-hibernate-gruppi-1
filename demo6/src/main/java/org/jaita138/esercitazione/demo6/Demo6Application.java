package org.jaita138.esercitazione.demo6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello group 3!");
	}

}
