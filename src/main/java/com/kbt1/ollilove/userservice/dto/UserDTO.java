package com.kbt1.ollilove.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kbt1.ollilove.userservice.domain.user.UserProfile;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {

    //유저정보
    private Long userId;
    private String userName;

    private String nickname;

    private UserProfile profile;




}
