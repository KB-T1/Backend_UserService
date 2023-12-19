package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Relation;
import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.repository.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationServiceImpl implements RelationService {

    private final RelationRepository relationRepository;
    private final UserService userService;

    //TODO targeterId, targetedId 가 존재하는 유저인지 exception처리
    public Boolean saveRelation(RelationDTO relationDTO) {

        Relation relation =
                Relation.builder()
                .targeterId(userService.findUserById(relationDTO.getTargeterId()))
                .targetedId(userService.findUserById(relationDTO.getTargetedId()))
                .nickname(relationDTO.getNickname())
                .build();

        relationRepository.save(relation);

        return true;
    }

}
