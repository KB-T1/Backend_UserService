package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import com.kbt1.ollilove.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public User findUserById(UserRequestDTO userRequestDTO){
        return userRepository.findById(userRequestDTO.getUserId()).orElseThrow(()-> new RuntimeException("해당 User 없음"));
    }

}
