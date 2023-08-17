package com.example.utilisateurservice.service;

import com.example.utilisateurservice.entity.UserApp;
import com.example.utilisateurservice.repository.UserAppRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;

    public UserAppService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    public UserApp createUserApp(String name, String email) {
        UserApp userApp = UserApp.builder().name(name).email(email).build();
        userAppRepository.save(userApp);
        return userApp;
    }

    public UserApp getUserById(int id) {
        Optional<UserApp> userAppOptional = userAppRepository.findById(id);
        if(userAppOptional.isPresent()) {
            return userAppOptional.get();
        }
        throw new RuntimeException("Not found");
    }
}
