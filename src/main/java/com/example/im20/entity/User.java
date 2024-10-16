package com.example.im20.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = true, length = 255)
    private String userName;

    @Column(name = "user_login_id", unique = true, length = 255)
    private String userLoginId;

    @Column(name = "user_password", nullable = true, length = 255)
    private String userPassword;

    @Column(name = "user_login_type", nullable = true)
    private Integer userLoginType;

    @Column(name = "user_sns_key", nullable = true)
    private Integer userSnsKey;

    @Column(name = "user_phone", unique = true, nullable = true)
    private Integer userPhone;

    @Column(name = "user_email", nullable = true, length = 255)
    private String userEmail;

    @Column(name = "user_parent_password", nullable = true, length = 255)
    private String userParentPassword;

    @Column(name = "user_stamp", nullable = false)
    private Integer userStamp;

    @Column(name = "user_profile_photo", nullable = true, length = 255)
    private String userProfilePhoto;

    @Column(name = "user_level", nullable = true)
    private Integer userLevel;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Manage> manages;
}