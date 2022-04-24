package com.practice.SecureApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_TELUSCO")
public class User

{
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String username;
	
	@Column(name="password")
	private String password;
	

}
