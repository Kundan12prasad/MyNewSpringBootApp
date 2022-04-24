package com.practice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.model.PlanEntity;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity,Serializable> 
{
	
	
	

}
