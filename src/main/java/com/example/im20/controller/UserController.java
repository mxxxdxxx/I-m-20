package com.example.im20.controller;

import com.example.im20.entity.User;
import com.example.im20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody User user) {
//        Optional<User> existingUser = userService.findByUserLoginId(user.getUserLoginId());
//        if (existingUser.isPresent() && existingUser.get().getUserPassword().equals(user.getUserPassword())) {
//            System.out.println("User login successful: " + user.getUserLoginId()); // 로그 출력
//            return ResponseEntity.ok(existingUser.get());
//        } else {
//            System.out.println("User login failed for: " + user.getUserLoginId()); // 로그 출력
//            return ResponseEntity.status(401).body(null); // Unauthorized
//        }
//    }

//    public ResponseEntity<User> loginUser(@RequestBody User user) {
//        System.out.println("Received login request: " + user.getUserLoginId());
//        Optional<User> existingUser = userService.findByUserLoginId(user.getUserLoginId());
//        if (existingUser.isPresent() && existingUser.get().getUserPassword().equals(user.getUserPassword())) {
//            return ResponseEntity.ok(existingUser.get());
//        } else {
//            return ResponseEntity.status(401).body(null); // Unauthorized
//        }
//    }
    /**
     * 로그인과 같은 경우에는 보통 @RequestBody를 사용하여 POST 요청을 처리함
     * 이는 보안과 관련이 있음 -> 사용자 자격 증명(예: 비밀번호)을 URL에 포함시키지 않기 때문
     * RequestParam: GET 요청에서 URL 쿼리 파라미터를 통해 데이터를 전달할 때 사용
     */
//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody User user) {
//        System.out.println("Received login request: " + user.getUserLoginId() + ", " + user.getUserPassword());
//        Optional<User> existingUser = userService.findByUserLoginId(user.getUserLoginId());
//        if (existingUser.isPresent() && existingUser.get().getUserPassword().equals(user.getUserPassword())) {
//            return ResponseEntity.ok(existingUser.get());
//        } else {
//            return ResponseEntity.status(401).body(null); // Unauthorized
//        }
//    }

    /**
     * RequestParam 방식
     */
//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(
//            @RequestParam String userLoginId,
//            @RequestParam String userPassword) {
//        System.out.println("Received login request: " + userLoginId + ", " + userPassword);
//        Optional<User> existingUser = userService.findByUserLoginId(userLoginId);
//        if (existingUser.isPresent() && existingUser.get().getUserPassword().equals(userPassword)) {
//            return ResponseEntity.ok(existingUser.get());
//        } else {
//            return ResponseEntity.status(401).body(null); // Unauthorized
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Map<String, String> request) {
        String userLoginId = request.get("userLoginId");
        String userPassword = request.get("userPassword");
        System.out.println("Received login request: " + userLoginId + ", " + userPassword);

        Optional<User> existingUser = userService.findByUserLoginId(userLoginId);
        if (existingUser.isPresent() && existingUser.get().getUserPassword().equals(userPassword)) {
            return ResponseEntity.ok(existingUser.get());
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    /**
     * 원래
     */

    /*
    @PostMapping("/{id}/level")
    public ResponseEntity<String> setUserLevel(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        String level = request.get("level");

        Optional<User> userOpt = userService.findUserById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUserLevel(Integer.parseInt(level));
            userService.saveUser(user);
            return ResponseEntity.ok("레벨 설정 성공");
        } else {
            return ResponseEntity.status(404).body("사용자를 찾을 수 없습니다");
        }
    }
    */

    /**
     * 테스트용 로그 출력
     */
    // 사용자 레벨 설정 엔드포인트
    @PostMapping("/{id}/level")
    public ResponseEntity<String> setUserLevel(@PathVariable Integer id, @RequestBody User request) {
        Integer level = request.getUserLevel();
        System.out.println("Received request to set level: " + level + " for user ID: " + id); // 로그 출력

        try {
            Optional<User> userOpt = userService.findUserById(id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();

                if (level == null) {
                    System.out.println("Level is null, setting default value.");
                    user.setUserLevel(0);   // 기본값으로 설정
                } else if (level == 0 || level == 1) {
                    System.out.println("Parsed level: " + level);
                    user.setUserLevel(level);
                } else {
                    System.out.println("Invalid level value: " + level);
                    return ResponseEntity.status(400).body("레벨 값은 0 또는 1이어야 합니다");
                }

                userService.saveUser(user);
                System.out.println("Level set successfully for user ID: " + id + " to level " + user.getUserLevel()); // 로그 출력
                return ResponseEntity.ok("레벨 설정 성공.");
            } else {
                System.out.println("User not found for ID: " + id); // 로그 출력
                return ResponseEntity.status(404).body("사용자를 찾을 수 없습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("내부 서버 오류");
        }
    }

    /**
     * 클라이언트에서 level 가져오기
     */
    @GetMapping("/{id}/level")
    public ResponseEntity<String> setUserLevel(@PathVariable Integer id, @RequestParam Integer level) {
        System.out.println("Received request to set level: " + level + " for user ID: " + id); // 로그 출력

        try {
            Optional<User> userOpt = userService.findUserById(id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();

                if (level == null) {
                    System.out.println("Level is null, setting default value.");
                    user.setUserLevel(0); // 기본값으로 설정
                } else if (level == 0 || level == 1) {
                    System.out.println("Parsed level: " + level);
                    user.setUserLevel(level);
                } else {
                    System.out.println("Invalid level value: " + level);
                    return ResponseEntity.status(400).body("레벨 값은 0 또는 1이어야 합니다");
                }

                userService.saveUser(user);
                System.out.println("Level set successfully for user ID: " + id + " to level " + user.getUserLevel()); // 로그 출력
                return ResponseEntity.ok("레벨 설정 성공.");
            } else {
                System.out.println("User not found for ID: " + id); // 로그 출력
                return ResponseEntity.status(404).body("사용자를 찾을 수 없습니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("내부 서버 오류");
        }
    }

    @PostMapping("/{id}/parent-password")
    public ResponseEntity<String> setParentPassword(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        String parentPassword = request.get("parentPassword");
        if (!userService.validateParentPassword(parentPassword)) {
            return ResponseEntity.badRequest().body("Invalid parent password. It must be a 4-digit integer.");
        }

        Optional<User> userOpt = userService.findUserById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUserParentPassword(parentPassword);
            userService.saveUser(user);
            return ResponseEntity.ok("Parent password set successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @GetMapping("/{id}/parent-password")
    public ResponseEntity<String> verifyParentPassword(@PathVariable Integer id, @RequestParam String parentPassword) {
        Optional<User> userOpt = userService.findUserById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getUserParentPassword().equals(parentPassword)) {
                return ResponseEntity.ok("Parent password verified successfully");
            } else {
                return ResponseEntity.status(401).body("Parent password is incorrect");
            }
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    // 특정 사용자 조회 엔드포인트
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 모든 사용자 조회 엔드포인트
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // 사용자 업데이트 엔드포인트
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        Optional<User> updatedUser = userService.updateUser(id, userDetails);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 사용자 삭제 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 사용자 부분 업데이트 엔드포인트
    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Optional<User> updatedUser = userService.partialUpdateUser(id, updates);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}