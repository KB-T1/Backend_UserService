package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.user.User;
import com.kbt1.ollilove.userservice.domain.user.UserProfile;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
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
    public ResultDTO<UserDTO> signup(SignupDTO signupDTO) {

        Family family = familyService.saveFamily(signupDTO.getFamilyId());
        User user = saveUser(family, signupDTO.getUserName(), signupDTO.getProfile());

        return ResultDTO.<UserDTO>builder()
                .success(true)
                .data(UserDTO.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .profile(user.getProfile())
                        .build())
                .build();
    }


    private User saveUser(Family family, String userName, UserProfile userProfile) {
        User user = User.builder()
                .userName(userName)
                .familyId(family)
                .profile(userProfile)
                .build();
        userRepository.save(user);

        return user;
    }

    @Transactional(readOnly = true)
    public ResultDTO<UserDTO> findUserInfoById(Long userId) {

        User user = findUserById(userId);

        return ResultDTO.<UserDTO>builder()
                .success(true)
                .data(UserDTO.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .profile(user.getProfile())
                        .build())
                .build();
    }


    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("해당 User 없음"));
    }

    public List<UserDTO> findRelationWithUsers(String familyId, Long targeterId){
        return userRepository.findByFamilyIdWithRelation(familyId,targeterId);
    }

}
