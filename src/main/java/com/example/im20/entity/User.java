package im20.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
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
    private String userLoginType;

    @Column(name = "user_sns_key")
    private Integer userSnsKey;

    @Column(name = "user_phone")
    private Integer userPhone;

    @Column(name = "user_parent_password")
    private String userParentPassword;

    @Column(name = "user_stamp")
    private Integer userStamp;

    @Column(name = "user_profile_photo")
    private String userProfilePhoto;

    @Column(name = "user_level")
    private Integer userLevel;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Manage> manages;

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLoginType() {
        return userLoginType;
    }

    public void setUserLoginType(String userLoginType) {
        this.userLoginType = userLoginType;
    }

    public Integer getUserSnsKey() {
        return userSnsKey;
    }

    public void setUserSnsKey(Integer userSnsKey) {
        this.userSnsKey = userSnsKey;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserParentPassword() {
        return userParentPassword;
    }

    public void setUserParentPassword(String userParentPassword) {
        this.userParentPassword = userParentPassword;
    }

    public Integer getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(Integer userStamp) {
        this.userStamp = userStamp;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}
