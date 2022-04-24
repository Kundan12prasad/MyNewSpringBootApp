package com.practice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="COUPON_DTLS")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUPON_ID")
	private Long id;
	@Column(name="COUPON_CODE")
	private String code;
	@Column(name="COUPON_DISCOUNT")
	private BigDecimal discount;	
	@Column(name="COUPON_EXPIARY_DATE")
	private String expDate;

}
