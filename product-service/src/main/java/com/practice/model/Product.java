package com.practice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT_DTLS")
public class Product {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private Long id;
	@Column(name="PRODUCT_NAME")
	private String name;
	@Column(name="PRODUCT_DESCRIPTION")
	private  String description;
	@Column(name="PRODUCT_PRICE")
	private BigDecimal price;
	@Transient
	private String couponCode;

}
