package com.laiszig.kitchen_story_backend.repository;

import com.laiszig.kitchen_story_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
