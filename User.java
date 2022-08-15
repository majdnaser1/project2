package com.example.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "id can't be Empty")
    @Size(min = 3,max = 10 ,message = "id must be longer than 3 characters ")
    private int id;
    @NotEmpty(message = "username can't be Empty")
    @Size(min = 3,max = 10 ,message = "username must be longer than 3 characters")
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6,max = 15,message = "password must be more than 6 char and less than 15 char")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "please enter strong password")
    private String password;
    @NotEmpty(message = "email can't be empty")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(admin|custamor)",message = "Role must be in admin or customer only")
    private String role;
    @NotEmpty(message = "balance can't be Empty")
    @Positive(message = "balance must be positive number")
    private int balance;


}
