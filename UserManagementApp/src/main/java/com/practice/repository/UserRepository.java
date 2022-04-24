package com.practice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Serializable>
{

	public  User findByEmailAndPazzword(String email,String pazzword);
	
	public User findByEmail(String email);
	
	

	
}
