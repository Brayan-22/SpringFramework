package com.example.restemplates.configuration;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder
                .build();
    }

    @Bean
    public Gson getGson(GsonBuilder builder) {
        return builder.setPrettyPrinting().create();
    }
}
