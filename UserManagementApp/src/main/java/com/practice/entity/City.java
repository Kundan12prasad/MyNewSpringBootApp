package com.practice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CITY_MSTR")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class City 
{
	@Id	
	@Column(name="CITY_ID")
	private Integer cityId;	
	
	@Column(name="CITY_NAME")
	private String cityName;
	
	@Column(name="STATE_ID")
	private Integer stateId;
	
	
	

	
}
