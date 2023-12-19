package com.kbt1.ollilove.userservice.dto;

import com.kbt1.ollilove.userservice.domain.user.UserProfile;
import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class SignupDTO {
    private String familyId;

    private String userName;
    private UserProfile profile;

}
