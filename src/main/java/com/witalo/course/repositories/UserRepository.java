package com.witalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witalo.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
