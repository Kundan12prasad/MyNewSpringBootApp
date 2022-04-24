package com.practice.SecureApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.SecureApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	
	User findByUsername(String username);	
	
}
