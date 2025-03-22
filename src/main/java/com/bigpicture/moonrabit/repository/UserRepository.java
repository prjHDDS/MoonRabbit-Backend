package com.bigpicture.moonrabit.repository;

import com.bigpicture.moonrabit.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 유저 찾기 ( 아이디 찾기 )
    Optional<User> findByEmail(String email);
}
