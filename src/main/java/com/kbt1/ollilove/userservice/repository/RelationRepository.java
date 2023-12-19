package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation, Long> {
}
