package com.kbt1.ollilove.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class FamilyDTO {
    private String familyId;
    private List<UserDTO> familyMember;
}
