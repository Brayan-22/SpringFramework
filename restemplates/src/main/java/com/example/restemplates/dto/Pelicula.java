package com.example.restemplates.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;


public record Pelicula(String Title,int Year,String Runtime,String Genre,String Director,String Language,String Country)
implements Serializable {
}
