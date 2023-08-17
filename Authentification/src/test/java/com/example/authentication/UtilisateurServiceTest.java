package com.example.authentication;

import com.example.authentication.entity.Utilisateur;
import com.example.authentication.repository.UtilisateurRepository;
import com.example.authentication.service.UtilisateurService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTest {
    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @Test
    public void shouldAddNewUtilisateurWhenValidDataProvided() {
        //Arrange
        Utilisateur utilisateur = new Utilisateur(1L,"toto", "1234");
        Mockito.when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);

        //Act
        Utilisateur result = utilisateurService.enregistrerUtilisateur( "toto", "1234");

        //Assert
        Assertions.assertEquals(utilisateur, result);
    }

}
