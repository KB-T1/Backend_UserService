package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.SignupDTO;
import com.kbt1.ollilove.userservice.dto.UserDTO;
import com.kbt1.ollilove.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FamilyService familyService;

    @Transactional
    public UserDTO signup(SignupDTO signupDTO) {

        Family family = familyService.saveFamily(signupDTO.getFamilyId());
        User user = saveUser(family, signupDTO.getUserName());

        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }


    private User saveUser(Family family, String userName) {
        User user = User.builder()
                .userName(userName)
                .familyId(family)
                .build();
        userRepository.save(user);

        return user;
    }

    @Transactional(readOnly = true)
    public UserDTO findUserInfoById(Long userId) {

        User user = findUserById(userId);

        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }

    //TODO 나중에 다시 생각해서 고치자~ 우선은 대충 돌아가나 보자~
    @Transactional(readOnly = true)
    public List<UserDTO> findFamilyInfoByUserId(Long userId) {

        Family family = findUserById(userId).getFamilyId();

        return userRepository.findUsersByFamilyId(family)
                .stream()
                .filter(user -> !user.getUserId().equals(userId))
                .map(user -> UserDTO.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .build())
                .toList();

    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("해당 User 없음"));
    }

}
