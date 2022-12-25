package com.example.carwashservice.User;

import com.example.carwashservice.dto.User;
import com.example.carwashservice.dto.UserAuthEntity;
import com.example.carwashservice.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    @GetMapping("/car-wash/login")
    public void login(Authentication authentication) {

        UserAuthEntity user = (UserAuthEntity) authentication.getPrincipal();

    }

    @PostMapping("/car-wash/register")
    public ResponseEntity<UserProfile> register(@RequestBody @Valid UserProfile userProfile) throws Exception {
        try {
            return new ResponseEntity<UserProfile>(userAuthService.registerNewUserAccount(userProfile), HttpStatus.OK);
        } catch (DataIntegrityViolationException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username Already Exist");
        }
    }

    @GetMapping(value = "/car-wash/logout")
    public void logout() {

    }

}
