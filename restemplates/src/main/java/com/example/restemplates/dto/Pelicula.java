package com.example.restemplates.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;


//public record Pelicula(String Title,int Year,String Runtime,String Genre,String Director,String Language,String Country)
//implements Serializable {
//}

public class Pelicula implements Serializable {
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private int Year;
    @JsonProperty("Runtime")
    private String Runtime;
    @JsonProperty("Genre")
    private String Genre;
    @JsonProperty("Director")
    private String Director;
    @JsonProperty("Language")
    private String Language;
    @JsonProperty("Country")
    private String Country;

    public Pelicula() {
    }

    public Pelicula(String title, int year, String runtime, String genre, String director, String language, String country) {
        Title = title;
        Year = year;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Language = language;
        Country = country;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "Title='" + Title + '\'' +
                ", Year=" + Year +
                ", Runtime='" + Runtime + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Language='" + Language + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}