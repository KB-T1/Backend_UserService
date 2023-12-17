package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import com.kbt1.ollilove.userservice.dto.UserResponseDTO;
import com.kbt1.ollilove.userservice.repository.FamilyRepository;
import com.kbt1.ollilove.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDTO findUserInfoById(UserRequestDTO userRequestDTO) {

        User user = findUserById(userRequestDTO.getUserId());

        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }

    //TODO familyId가 null일 경우 해당 user가 존재하지 않는 것. exception or emptyList
    //TODO 나중에 다시 생각해서 고치자~ 우선은 대충 돌아가나 보자~
    //TODO 자기 자신 제외하고 가족들만????
    @Transactional(readOnly = true)
    public List<UserResponseDTO> findFamilyInfoByUserId(UserRequestDTO userRequestDTO) {

        Family family = findUserById(userRequestDTO.getUserId()).getFamilyId();

//        if (familyId == null){
//            return Collections.emptyList();
//        }

        return userRepository.findUsersByFamilyId(family)
                .stream()
                .map(user -> {
                    return UserResponseDTO.builder()
                            .userId(user.getUserId())
                            .userName(user.getUserName())
                            .build();
                }).toList();

    }

    private User findUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("해당 User 없음"));
    }

}
