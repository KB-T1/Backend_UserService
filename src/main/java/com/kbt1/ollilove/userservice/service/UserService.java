package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.dto.SignupDTO;
import com.kbt1.ollilove.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO signup(SignupDTO signupDTO);

    UserDTO findUserInfoById(Long userId);

    List<UserDTO> findFamilyInfoByUserId(Long userId);

}
