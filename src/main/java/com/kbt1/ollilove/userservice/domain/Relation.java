package com.kbt1.ollilove.userservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Relation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targeter_id",nullable = false)
    private User targeterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targeted_id",nullable = false)
    private User targetedId;
    private String nickname;
    private Integer relationType;
    private Integer messageCnt;
    private Integer callCnt;
}
