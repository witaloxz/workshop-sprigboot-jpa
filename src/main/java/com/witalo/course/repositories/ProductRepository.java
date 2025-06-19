package com.witalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witalo.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
