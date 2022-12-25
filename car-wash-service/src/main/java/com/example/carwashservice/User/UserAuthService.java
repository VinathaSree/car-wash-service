package com.example.carwashservice.User;

import com.example.carwashservice.dto.UserAuthEntity;
import com.example.carwashservice.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserAuthService {
        @Autowired
        BCryptPasswordEncoder passwordEncoder;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private UserAuthRepository userAuthRepository;


        public UserProfile registerNewUserAccount(UserProfile userProfile) throws DataIntegrityViolationException {

            UserEntity userEntity = UserEntity.builder().email(userProfile.getEmail()).mobileNumber(userProfile.getMobileNumber()).build();

            UserEntity savedUser = userRepository.saveAndFlush(userEntity);
            String encodedPassword = passwordEncoder.encode(userProfile.getPassword());
            UserAuthEntity userAuth = UserAuthEntity.
                    builder().id(savedUser.getId())
                    .password(encodedPassword)
                    .build();

            return userProfile;
        }

        public String passwordEncrypt(String password) {

            return passwordEncoder.encode(password);
        }
    }
