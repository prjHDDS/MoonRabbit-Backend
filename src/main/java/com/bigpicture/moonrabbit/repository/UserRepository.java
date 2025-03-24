package com.bigpicture.moonrabbit.repository;

import com.bigpicture.moonrabbit.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 유저 찾기 ( 아이디 찾기 )
    Optional<User> findByEmail(String email);
}
