package com.practice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Coupon;
import com.practice.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	private CouponRepository couponRepository;
	
	@PostMapping(value="/coupons")
	public Coupon create(@RequestBody Coupon coupon)
	{
		Coupon couponcreated = couponRepository.save(coupon);		
		return couponcreated;	}
	
	
	@GetMapping(value="/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code)
	{
		Coupon findByCode = couponRepository.findByCode(code);
		return findByCode;
		
	}
}
