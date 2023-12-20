package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.user.User;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
import com.kbt1.ollilove.userservice.dto.SignupDTO;
import com.kbt1.ollilove.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    ResultDTO<UserDTO> signup(SignupDTO signupDTO);

    ResultDTO<UserDTO> findUserInfoById(Long userId);


    User findUserById(Long userId);

    List<UserDTO> findRelationWithUsers(String familyId, Long targeterId);

}
