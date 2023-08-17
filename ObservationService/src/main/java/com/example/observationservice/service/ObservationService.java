package com.example.observationservice.service;

import com.example.observationservice.entity.Observation;
import com.example.observationservice.repository.ObservationRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ObservationService {

    private final ObservationRepository observationRepository;

    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public Observation createObservation(Long utilisateurId, String name, String description, String urlImage) {
        Observation observation = Observation.builder()
                .utilisateurId(utilisateurId)
                .name(name)
                .description(description)
                .urlImage(urlImage)
                .build();
        return observationRepository.save(observation);
    }

    public Observation getObservationByName(String name) {
        return observationRepository.findByName(name);
    }

    public Observation getObservationByDate(LocalDate date) {
        return observationRepository.findByDate(date);
    }

   public List<Observation> getObservationByUtilisateurId(Long utilisateurId) {
            return observationRepository.findByUtilisateurId(utilisateurId);
        }

}
