package com.practice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Serializable>
{

	public Coupon findByCode(String code);
	
	
}
