package com.example.observationservice.repository;

import com.example.observationservice.entity.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ObservationRepository  extends CrudRepository<Observation, Integer> {
     Observation findByName(String name);

    Observation findByDate (LocalDate date);

     List<Observation> findByUtilisateurId(Long utilisateurId);

     Observation save(Observation observation);


}
