package com.lilianlima.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lilianlima.springProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
