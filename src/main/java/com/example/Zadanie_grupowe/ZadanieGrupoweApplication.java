package com.example.Zadanie_grupowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController     
public class ZadanieGrupoweApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadanieGrupoweApplication.class, args); 
    }

    @GetMapping("/hello")
    public Map<String, Object> witaj() {
        Map<String, Object> odpowiedz = new HashMap<>();
        
        odpowiedz.put("message", "Aplikacja działa za pomocą Spring Boot");
        odpowiedz.put("team", "Grupa-Dziewczyny"); 
        odpowiedz.put("indexes", Arrays.asList(75565, 77020, 75723));
        odpowiedz.put("members", Arrays.asList("Yuliia Nahorna", "Marta Makarova", "Polina Kolesnikova"));
        
        return odpowiedz;
    }
}