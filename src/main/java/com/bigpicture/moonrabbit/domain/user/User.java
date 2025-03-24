package com.bigpicture.moonrabbit.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String email;


    @NotNull(message = "비밀번호는 필수 입력입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$",
            message = "비밀번호는 최소 8자 이상이어야 하며, 적어도 하나의 영문자와 하나의 특수 문자를 포함해야 합니다.")
    private String password;

    private String nickname;
    private String profileImg;
    private String role = ROLE_USER;
}
