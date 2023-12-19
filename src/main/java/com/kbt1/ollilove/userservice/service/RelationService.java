package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Relation;
import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;

import java.util.List;

public interface RelationService {

    ResultDTO saveRelation(RelationDTO relationDTO);

    List<Relation> findRelationWithUsers(String familyId,Long targeterId);

    ResultDTO<FamilyDTO> findFamilyInfoByUserId(Long userId);
}
