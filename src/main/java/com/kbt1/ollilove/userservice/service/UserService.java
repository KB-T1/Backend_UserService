package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;

public interface UserService {

    User findUserById(UserRequestDTO userRequestDTO);

}
