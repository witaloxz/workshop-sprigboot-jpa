package com.witalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.witalo.course.entities.OrderItem;
import com.witalo.course.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
