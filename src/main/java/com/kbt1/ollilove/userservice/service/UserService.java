package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.user.User;
import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
import com.kbt1.ollilove.userservice.dto.SignupDTO;
import com.kbt1.ollilove.userservice.dto.UserDTO;

public interface UserService {

    ResultDTO<UserDTO> signup(SignupDTO signupDTO);

    ResultDTO<UserDTO> findUserInfoById(Long userId);


    User findUserById(Long userId);

}
