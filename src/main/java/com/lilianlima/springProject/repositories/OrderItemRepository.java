package com.lilianlima.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilianlima.springProject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
