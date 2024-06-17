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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_login_id")
    private String userLoginId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_login_type")
    private Integer userLoginType;

    @Column(name = "user_sns_key")
    private Integer userSnsKey;

    @Column(name = "user_phone")
    private Integer userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_parent_password")
    private String userParentPassword;

    @Column(name = "user_stamp")
    private Integer userStamp;

    @Column(name = "user_profile_photo")
    private String userProfilePhoto;

    @Column(name = "user_level")
    private Integer userLevel;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Manage> manages;
}
