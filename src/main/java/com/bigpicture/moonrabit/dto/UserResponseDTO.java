package com.bigpicture.moonrabit.dto;

import com.bigpicture.moonrabit.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserResponseDTO {
    private String email;
    private String nickname;
    private String profileImg;

    public UserResponseDTO(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.profileImg = user.getProfileImg();
    }
}
