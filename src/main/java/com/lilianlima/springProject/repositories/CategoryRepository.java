package com.lilianlima.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilianlima.springProject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
