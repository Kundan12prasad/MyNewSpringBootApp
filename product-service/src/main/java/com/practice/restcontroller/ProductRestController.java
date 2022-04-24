package com.practice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.dto.Coupon;
import com.practice.model.Product;
import com.practice.repository.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceURL;	
	
	@PostMapping(value="/products")
	public Product create(@RequestBody Product product)	{
		
		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
	    product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);	
		
	}
		
	/*
	 * public Product sendErrorResponse(Product product) { return product; }
	 */
		
		
	
}
