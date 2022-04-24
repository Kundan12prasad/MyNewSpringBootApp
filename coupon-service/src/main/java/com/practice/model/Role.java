package com.practice.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLE_DTLS")
@Data

public class Role implements GrantedAuthority 
{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	@Override
	public String getAuthority() 
	{
		return name;
	} 


}
