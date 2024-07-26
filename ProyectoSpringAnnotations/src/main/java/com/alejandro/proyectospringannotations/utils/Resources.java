package com.alejandro.proyectospringannotations.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Resources {
    private static final Path RESOURCES = Paths.get(Path.of(".").toAbsolutePath().toString(),"src","main","resources");
    public static Path getResources(String fileName){
        return Path.of(RESOURCES.toString(),fileName);
    }
}
