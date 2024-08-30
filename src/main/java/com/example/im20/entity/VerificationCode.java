package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "email")
public class VerificationCode {

    @Id
    private String email;
    private String code;
    private LocalDateTime expirationTime;

    // Getters and setters
}

