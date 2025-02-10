package org.jaita138.esercitazione.demo6;

import org.jaita138.esercitazione.demo6.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo6Application implements CommandLineRunner {

	@Autowired
	private AutoreService autoreService;

	@Autowired
	private GenereService genereService;

	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		new CliManager(autoreService, genereService, libroService);
	}

}
