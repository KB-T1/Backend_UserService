package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Long> {
    //@Query("SELECT DISTINCT r, u FROM Relation r Left JOIN FETCH User u ON u.userId = r.targetedId.userId WHERE u.familyId.familyId = :familyId AND r.targeterId.userId = :targeterId")
    //@Query("SELECT DISTINCT r, u FROM Relation r right JOIN FETCH User u ON u.userId = r.targetedId.userId AND r.targeterId.userId = :targeterId WHERE u.familyId.familyId = :familyId")
    //List<Relation> findByFamilyIdWithUsers(@Param("familyId") String familyId, @Param("targeterId") Long targeterId);
}
