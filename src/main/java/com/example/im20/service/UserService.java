package com.example.im20.service;

import com.example.im20.entity.User;
import com.example.im20.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUserLoginId(String userLoginId) {
        return userRepository.findByUserLoginId(userLoginId);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> updateUser(Integer id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(userDetails.getUserName());
            user.setUserLoginId(userDetails.getUserLoginId());
            user.setUserPassword(userDetails.getUserPassword());
            user.setUserLoginType(userDetails.getUserLoginType());
            user.setUserSnsKey(userDetails.getUserSnsKey());
            user.setUserPhone(userDetails.getUserPhone());
            user.setUserEmail(userDetails.getUserEmail());
            user.setUserParentPassword(userDetails.getUserParentPassword());
            user.setUserStamp(userDetails.getUserStamp());
            user.setUserProfilePhoto(userDetails.getUserProfilePhoto());
            user.setUserLevel(userDetails.getUserLevel());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(Integer id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    /**
     * user 데이터 부분 업데이트
     * key에 따라 부분적 수정
     * @param id
     * @param updates
     * @return
     */
    public Optional<User> partialUpdateUser(Integer id, Map<String, Object> updates) {
        return userRepository.findById(id).map(user -> {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "userName": user.setUserName((String) value); break;
                    case "userLoginId": user.setUserLoginId((String) value); break;
                    case "userPassword": user.setUserPassword((String) value); break;
                    case "userLoginType": user.setUserLoginType((Integer) value); break;
                    case "userSnsKey": user.setUserSnsKey((Integer) value); break;
                    case "userPhone": user.setUserPhone((Integer) value); break;
                    case "userEmail": user.setUserEmail((String) value); break;
                    case "userParentPassword": user.setUserParentPassword((String) value); break;
                    case "userStamp": user.setUserStamp((Integer) value); break;
                    case "userProfilePhoto": user.setUserProfilePhoto((String) value); break;
                    case "userLevel": user.setUserLevel((Integer) value); break;
                }
            });
            return userRepository.save(user);
        });
    }


    /**
     * 학부모용 비밀번호 4글자 10진수 확인
     */
    public boolean validateParentPassword(String parentPassword) {
        if (parentPassword == null) {
            return false;
        }
        // "\\d{4}"로 수정합니다. 이는 4자리 숫자만 허용합니다.
        return parentPassword.matches("\\d{4}");
    }
}
