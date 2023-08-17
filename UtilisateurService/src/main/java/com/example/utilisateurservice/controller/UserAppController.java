package com.example.utilisateurservice.controller;

import com.example.utilisateurservice.entity.UserApp;
import com.example.utilisateurservice.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAppController {

    private final UserAppService userAppService;

    public UserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @PostMapping("")
    public ResponseEntity<UserApp> post(@RequestParam String name, @RequestParam String email) {
        UserApp userApp = userAppService.createUserApp(name, email);
        return ResponseEntity.ok(userApp);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserApp> get(@PathVariable int id) {
        UserApp userApp = userAppService.getUserById(id);
        return ResponseEntity.ok(userApp);
    }

}
