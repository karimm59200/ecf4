package com.example.observationservice.dto;

import com.example.observationservice.entity.Observation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ObservationDTO {

    private List<Observation> observations;

    private UserDTO userDTO;
}
