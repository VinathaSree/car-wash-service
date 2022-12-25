package com.example.carwashservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class User {
    @NotNull
    @NotEmpty
    String name;
    @NotNull
    @NotEmpty
    String mailId;
    @NotNull
    @NotEmpty
    String password;
}
