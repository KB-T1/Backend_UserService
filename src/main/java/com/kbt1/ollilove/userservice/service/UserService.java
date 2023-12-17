package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import com.kbt1.ollilove.userservice.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO findUserInfoById(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> findFamilyInfoByUserId(UserRequestDTO userRequestDTO) ;

}
