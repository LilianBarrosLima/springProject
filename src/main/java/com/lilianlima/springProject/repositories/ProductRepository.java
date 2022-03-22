package com.lilianlima.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilianlima.springProject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
