package com.example.restemplates.services;


import com.example.restemplates.dto.Pelicula;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PeliculaService {
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final Gson gson;


    public List<Pelicula> getPeliculas() {
        Pelicula[] response = restTemplate.getForObject("",Pelicula[].class);
        return Arrays.asList(response);
    }
    public Optional<Pelicula> getPelicula(String title) throws Exception {
        StringBuilder strb = new StringBuilder("");
        strb.append("https://www.omdbapi.com/?t=");
        strb.append(title.replaceAll(" ","+"));
        strb.append("&apikey=66e60764");
        log.info(strb.toString());
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(strb.toString())).build();
        HttpResponse<String> responseBasic = cliente.send(request, HttpResponse.BodyHandlers.ofString()) ;
        if (responseBasic.statusCode() == HttpURLConnection.HTTP_OK) {
            //return Optional.of(gson.fromJson(responseBasic.body(), Pelicula.class));
        }
        ResponseEntity<String> response = restTemplate.getForEntity(strb.toString(), String.class);
        log.info(response.toString());
        //return Optional.empty();
        return Optional.of(restTemplate.getForObject(strb.toString(), Pelicula.class));
        //return pelicula;
    }
}
