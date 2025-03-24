package com.bigpicture.moonrabbit.domain.user.controller;


import com.bigpicture.moonrabbit.domain.user.entity.User;
import com.bigpicture.moonrabbit.domain.user.dto.UserResponseDTO;
import com.bigpicture.moonrabbit.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    // 유저 저장
    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        UserResponseDTO responseDTO = new UserResponseDTO(savedUser);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // 이메일로 유저 찾기
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(new UserResponseDTO(user));
    }
}
