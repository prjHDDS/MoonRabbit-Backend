package com.bigpicture.moonrabit.service;

import com.bigpicture.moonrabit.domain.user.User;
import com.bigpicture.moonrabit.exception.UserAlreadyExistsException;
import com.bigpicture.moonrabit.exception.UserNotFoundException;
import com.bigpicture.moonrabit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 유저 저장
    public User saveUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    // 이메일로 유저 찾기
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
}
