package com.example.observationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long utilisateurId;

    private String name;

    private LocalDate date = LocalDate.now();

    private String description;

    private String  urlImage;

    private Boolean isPublic;

    public Observation(int id, Long utilisateurId, String name, String description, String urlImage, Boolean isPublic) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
    }
}
