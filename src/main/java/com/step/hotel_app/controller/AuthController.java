package com.step.hotel_app.controller;

import com.step.hotel_app.service.AppUserDetailService;
import com.step.hotel_app.views.UserRegistrationReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {
    private final AppUserDetailService appUserDetailService;

    public AuthController(AppUserDetailService appUserDetailService) {
        this.appUserDetailService = appUserDetailService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationReq user){
        boolean success = appUserDetailService.register(user);
        return success ? ResponseEntity.accepted().build() : ResponseEntity.ok("not registered");
    }
}
