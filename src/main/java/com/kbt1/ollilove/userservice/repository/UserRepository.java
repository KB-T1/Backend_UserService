package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.Family;
import com.kbt1.ollilove.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByFamilyId(Family familyId);

    @Query("SELECT u FROM User u WHERE u.familyId = :familyId")
    List<User> findUsersByFamilyId(@Param("familyId") Long familyId);

}
