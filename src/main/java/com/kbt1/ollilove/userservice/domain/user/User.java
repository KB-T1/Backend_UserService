package com.kbt1.ollilove.userservice.domain.user;

import com.kbt1.ollilove.userservice.domain.BaseTimeEntity;
import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.Relation;
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
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id",nullable = false)
    private Family familyId;

    @Column
    @Enumerated(EnumType.STRING)
    private UserProfile profile;



}
