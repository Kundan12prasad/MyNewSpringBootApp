package com.practice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State,Serializable>
{

	public List<State>  findByCountryId(Integer countryId);

	
	
}
