package com.lilianlima.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilianlima.springProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
