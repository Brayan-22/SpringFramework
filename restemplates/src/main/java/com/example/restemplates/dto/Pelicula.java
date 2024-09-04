package com.example.restemplates.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;

@Data
public class Pelicula implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private String Title;
    private int Year;
    private int Runtime;
    private String Genre;
    private String Director;
    private String Language;
    private String Country;
}
