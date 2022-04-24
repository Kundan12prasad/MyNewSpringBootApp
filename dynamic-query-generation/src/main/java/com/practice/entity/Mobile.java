package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MOBILE_DTLS")
@Data
public class Mobile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MOBILE_ID")
	private Integer mobileId;
	
	@Column(name="MOBILE_BRAND")
	private String mobileBrand;
	
	@Column(name="MOBILE_RAM")
	private String mobileRam;
	
	@Column(name="MOBILE_PRICE")
	private Double mobilePrice;
	

}
