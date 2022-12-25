package com.example.carwashservice.dto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserProfile {


        @NotNull
        @NotEmpty
        private String email;

        @NotNull
        @NotEmpty
        private String password;

        @NotNull
        @NotEmpty
        private String mobileNumber;
    }

