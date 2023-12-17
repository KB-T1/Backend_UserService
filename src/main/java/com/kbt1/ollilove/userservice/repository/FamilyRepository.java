package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    
}
