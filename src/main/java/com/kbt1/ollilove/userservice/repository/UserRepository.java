package com.kbt1.ollilove.userservice.repository;

import com.kbt1.ollilove.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
