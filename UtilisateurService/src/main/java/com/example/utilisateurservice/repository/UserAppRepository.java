package com.example.utilisateurservice.repository;


import com.example.utilisateurservice.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends CrudRepository<UserApp, Integer> {
}
