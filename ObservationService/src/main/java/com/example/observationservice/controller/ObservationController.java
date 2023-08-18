package com.example.observationservice.controller;

import com.example.observationservice.entity.Observation;
import com.example.observationservice.service.ObservationService;
import com.example.observationservice.tool.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationController {

    private final ObservationService observationService;

    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    @PostMapping("")
    public ResponseEntity<Observation> post(@RequestParam Long utilisateurId, @RequestParam String name, @RequestParam String description, @RequestParam String urlImage) {
       // Observation observation = observationService.createObservation(1L, "observation1", null, "description1", "urlImage1");
        Observation observation = observationService.createObservation(utilisateurId, name, description, urlImage, true);
        return ResponseEntity.ok(observation);
    }

    @GetMapping("{utilisateurId}")
    public ResponseEntity<List<Observation>> get(@PathVariable Long utilisateurId, @RequestHeader("Authorization") String token) {

        try {
            RestClient<String, String> restClient = new RestClient<>();
            if(restClient.testToken(token, String.class)) {
                return ResponseEntity.ok(observationService.getObservationByUtilisateurId(utilisateurId));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }

    }

    @GetMapping("name/{name}")
    public ResponseEntity<Observation> getByName(@PathVariable String name, @RequestHeader("Authorization") String token) {

        try {
            RestClient<String, String> restClient = new RestClient<>();
            if(restClient.testToken(token, String.class)) {
                return ResponseEntity.ok(observationService.getObservationByName(name));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }

    }

    @GetMapping("date/{date}")
    public ResponseEntity<Observation> getByDate(@PathVariable LocalDate date, @RequestHeader("Authorization") String token) {

        try {
            RestClient<String, String> restClient = new RestClient<>();
            if(restClient.testToken(token, String.class)) {
                return ResponseEntity.ok(observationService.getObservationByDate(date));
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }

    }
}
