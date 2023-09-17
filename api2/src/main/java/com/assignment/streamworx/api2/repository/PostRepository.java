package com.assignment.streamworx.api2.repository;

import com.assignment.streamworx.api2.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByUserid(Integer userid);
}
