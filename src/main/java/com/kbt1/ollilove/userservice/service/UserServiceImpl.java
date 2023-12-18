package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserResponseDTO;
import com.kbt1.ollilove.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDTO findUserInfoById(Long userId) {

        User user = findUserById(userId);

        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }

    //TODO familyId가 null일 경우 해당 user가 존재하지 않는 것. exception or emptyList
    //TODO 나중에 다시 생각해서 고치자~ 우선은 대충 돌아가나 보자~
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findFamilyInfoByUserId(Long userId) {

        Family family = findUserById(userId).getFamilyId();

//        if (familyId == null){
//            return Collections.emptyList();
//        }

        return userRepository.findUsersByFamilyId(family)
                .stream()
                .filter(user -> !user.getUserId().equals(userId))
                .map(user -> UserResponseDTO.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .build())
                .toList();

    }

    private User findUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("해당 User 없음"));
    }

}
