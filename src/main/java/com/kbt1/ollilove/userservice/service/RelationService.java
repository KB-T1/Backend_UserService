package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;

public interface RelationService {

    ResultDTO saveRelation(RelationDTO relationDTO);


    ResultDTO<FamilyDTO> findFamilyInfoByUserId(Long userId);
}
