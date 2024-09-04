package com.example.restemplates.services;


import com.example.restemplates.dto.Pelicula;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PeliculaService {
    private final RestTemplate restTemplate;

    public List<Pelicula> getPeliculas() {
        Pelicula[] response = restTemplate.getForObject("",Pelicula[].class);
        return Arrays.asList(response);
    }
    public Pelicula getPelicula(String title) {
        StringBuilder strb = new StringBuilder("");
        strb.append("https://www.omdbapi.com/?t=");
        strb.append(title.replaceAll(" ","+"));
        strb.append("&apikey=66e60764");
        log.info(strb.toString());
        ResponseEntity<String> response = restTemplate.getForEntity(strb.toString(), String.class);
        log.info(response.getBody());
        return restTemplate.getForObject(strb.toString(), Pelicula.class);
    }
}
