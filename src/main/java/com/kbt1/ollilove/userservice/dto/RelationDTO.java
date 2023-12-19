package com.kbt1.ollilove.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class RelationDTO {
    private Long targeterId;
    private Long targetedId;
    private String nickname;
}
