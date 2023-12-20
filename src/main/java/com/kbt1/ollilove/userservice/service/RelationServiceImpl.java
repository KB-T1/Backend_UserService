package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.Relation;
import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
import com.kbt1.ollilove.userservice.repository.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RelationServiceImpl implements RelationService {

    private final RelationRepository relationRepository;
    private final UserService userService;

    //TODO targeterId, targetedId 가 존재하는 유저인지 exception처리
    public ResultDTO saveRelation(RelationDTO relationDTO) {

        Relation relation =
                Relation.builder()
                        .relationId(getRelationId(relationDTO.getTargeterId(), relationDTO.getTargetedId()))
                        .targeterId(userService.findUserById(relationDTO.getTargeterId()))
                        .targetedId(userService.findUserById(relationDTO.getTargetedId()))
                        .nickname(relationDTO.getNickname())
                        .build();

        relationRepository.save(relation);

        return ResultDTO.builder()
                .success(true)
                .build();

    }

    //TODO 나중에 utils로 바꾸기
    private String getRelationId(Long targeterId, Long targetedId) {
        return "RE" + targeterId + targetedId;
    }


    @Transactional(readOnly = true)
    public ResultDTO<FamilyDTO> findFamilyInfoByUserId(Long userId) {

        Family family = userService.findUserById(userId).getFamilyId();
        FamilyDTO familyDTO = FamilyDTO.builder()
                .familyId(family.getFamilyId())
                .familyMember(
                        userService.findRelationWithUsers(family.getFamilyId(), userId)
                )
                .build();
        return ResultDTO.<FamilyDTO>builder()
                .success(true)
                .data(familyDTO)
                .build();

    }


}
