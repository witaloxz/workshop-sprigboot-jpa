package com.witalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witalo.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
