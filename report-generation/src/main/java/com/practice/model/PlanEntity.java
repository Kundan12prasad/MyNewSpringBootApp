package com.practice.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PLAN_MSTR")
@Data
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="PLAN_STARTDATE")
	private LocalDate planStartDate;
	
	@Column(name="PLAN_ENDDATE")
	private LocalDate planEndDate;
	
	@Column(name="PLAN_BENEFIT_AMOUNT")
	private Long benefitAmount;	

}
