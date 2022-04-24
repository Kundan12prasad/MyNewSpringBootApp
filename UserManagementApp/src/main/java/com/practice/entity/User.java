package com.practice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER_MSTR")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")	
	private Integer userId;
	
	@Column(name="USER_FIRST_NAME")	
	private String fname;
	
	@Column(name="USER_LAST_NAME")	
	private String lname;
	
	@Column(name="USER_EMAIL", unique=true)	
	private String email;
	
	@Column(name="USER_PHONE_NO")	
	private Long phno;
	
	@Column(name="USER_DOB")	
	private LocalDate dob;
	
	@Column(name="GENDER")	
	private String gender;
	
	@Column(name="COUNTRY")	
	private Integer countryId;
	
	@Column(name="STATE")	
	private Integer stateId;
	
	@Column(name="CITY")	
	private Integer cityId;
	
	@Column(name="ACCNT_STATUS")
	private String accStatus;
	
	@Column(name="USER_PASSWORD")
	private String pazzword;
	
	@Column(name="CREATED_DATE", updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE", insertable=false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	

		
	

}
