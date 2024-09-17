package com.example.restemplates;

import com.example.restemplates.dto.Pelicula;
import com.example.restemplates.services.PeliculaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class RestemplatesApplication implements CommandLineRunner {

	@Autowired
	private final PeliculaService peliculaService;

	public static void main(String[] args) {
		SpringApplication.run(RestemplatesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pelicula p = peliculaService.getPelicula("interstellar").get();
		log.info(p.toString());
	}
}
