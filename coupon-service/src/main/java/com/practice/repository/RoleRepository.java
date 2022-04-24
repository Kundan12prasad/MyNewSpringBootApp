package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> 
{

}
