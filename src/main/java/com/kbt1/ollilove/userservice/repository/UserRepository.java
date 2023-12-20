package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.Relation;
import com.kbt1.ollilove.userservice.domain.user.User;
import com.kbt1.ollilove.userservice.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findUsersByFamilyId(Family familyId);

    @Query("SELECT u FROM User u WHERE u.familyId = :familyId")
    List<User> findUsersByFamilyId(@Param("familyId") Long familyId);

    //@Query("SELECT DISTINCT r, u FROM User u Left JOIN FETCH Relation r ON u.userId = r.targetedId.userId AND r.targeterId.userId = :targeterId WHERE u.familyId.familyId = :familyId")
    //List<User> findByFamilyIdWithRelation(@Param("familyId") String familyId, @Param("targeterId") Long targeterId);

    @Query("SELECT new com.kbt1.ollilove.userservice.dto.UserDTO(u.userId, u.userName,r.nickname,u.profile) FROM User u Left JOIN FETCH Relation r ON u.userId = r.targetedId.userId AND r.targeterId.userId = :targeterId WHERE u.familyId.familyId = :familyId")
    List<UserDTO> findByFamilyIdWithRelation(@Param("familyId")String familyId, @Param("targeterId") Long targeterId);
}
