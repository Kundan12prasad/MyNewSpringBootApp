package com.practice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="COUNTRY_MSTR")
public class Country 
{
	@Id
	@Column(name="COUNTRY_ID")	
	private Integer countryId;
	
	@Column(name="COUNTRY_NAME")	
	private String countryName;
	
	@Column(name="COUNTRY_CODE")	
	private String countryCode;
	
		
	
	

}
