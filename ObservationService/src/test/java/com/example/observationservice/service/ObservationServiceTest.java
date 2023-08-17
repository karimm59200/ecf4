package com.example.observationservice.service;


import com.example.observationservice.repository.ObservationRepository;
import com.example.observationservice.entity.Observation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ObservationServiceTest {

    @Mock
    private ObservationRepository observationRepository;

    @InjectMocks
    private ObservationService observationService;


    @Test
    public void shouldAddNewObservationWhenValidDataProvided() {
        //Arrange
        Observation observation = new Observation(1,1L,"Mars", "Planète rouge", "https://www.nasa.gov/sites/default/files/thumbnails/image/pia21723-16.jpg" );
        Mockito.when(observationRepository.save(observation)).thenReturn(observation);

        //Act
        Observation result = observationService.createObservation(1L,"mars", "Planète rouge", "https://www.nasa.gov/sites/default/files/thumbnails/image/pia21723-16.jpg");

        //Assert
        Assertions.assertEquals(observation, result);
    }

    @Test
    void getObservationByName() {

        //Arrange
        Observation observation = new Observation(1,1L,"Mars", "Planète rouge", "https://www.nasa.gov/sites/default/files/thumbnails/image/pia21723-16.jpg" );
        Mockito.when(observationRepository.findByName("Mars")).thenReturn(observation);
        //Act
        Observation result = observationService.getObservationByName("Mars");
        //Assert
        Assertions.assertEquals(observation, result);
    }

    @Test
    public void testGetObservationByName() {


        ObservationService observationService = new ObservationService(observationRepository);


        String name = "Terre";
        Observation fakeObservation = new Observation();
        fakeObservation.setName(name);


        Mockito.when(observationRepository.findByName(name)).thenReturn(fakeObservation);


        Observation resultObservation = observationService.getObservationByName(name);


        Assertions.assertNotNull(resultObservation);
        Assertions.assertEquals(name, resultObservation.getName());


        Mockito.verify(observationRepository).findByName(name);
    }
//
//    @Test
//    void getObservationByDate() {
//    }
//
//    @Test
//    void getObservationByUtilisateurId() {
//    }
//
////    @Test
////    public void shouldAddNewPlantWhenValidDataProvided() {
////        //Arrange
////        Plante plante = new Plante("Rose", "Fleur rose", 1);
////        Mockito.when(planteRepository.save(plante)).thenReturn(plante);
////
////        //Act
////        Plante result = planteService.ajouterPlante("Rose", "Fleur rose", 1);
////
////        //Assert
////        Assertions.assertEquals(plante, result);
////    }
////
////
////    @Test
////    public void shouldReturnPlantByIdWhenExists() {
////
////    }
////
////    @Test
////    public void shouldRaiseExceptionWhenPlantByIdNotFound() {
////
////    }
//

}
