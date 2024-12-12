package com.rapifuzz.incident_management.model;

import com.rapifuzz.incident_management.constants.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private String pinCode;

    private String city;
    private String country;
    @OneToMany(mappedBy = "user")
    private Set<Incident> incidents;

    @Enumerated(EnumType.STRING)
    private Role role;
}
