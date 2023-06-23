package com.kurlic.labyrinthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LabyrinthServerMavenApplication
{

    public static void main(String[] args) {
        SpringApplication.run(LabyrinthServerMavenApplication.class, args);
    }

}
