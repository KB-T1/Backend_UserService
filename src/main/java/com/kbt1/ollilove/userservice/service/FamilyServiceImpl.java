package com.kbt1.ollilove.userservice.service;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository familyRepository;

    @Transactional
    public Family saveFamily(String familyId) {
        //familyId가 존재할 경우, 걍 넘기기
        //familyId가 존재하지 않을 경우, 저장
        //but, 둘다 영속성컨텍스트로 알아서 확인
        Family family = Family.builder()
                .familyId(familyId)
                .build();

        familyRepository.save(family);

        return family;
    }
}
