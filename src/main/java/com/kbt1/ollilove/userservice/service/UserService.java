package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO findUserInfoById(Long userId);

    List<UserResponseDTO> findFamilyInfoByUserId(Long userId);

}
