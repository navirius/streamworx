package com.assignment.streamworx.api2.repository;

import com.assignment.streamworx.api2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
