package com.ecommerce.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", length = 20)
	@Enumerated(EnumType.STRING)
	private RoleType type;

	public Role() {}
	
	public Role(RoleType type) {
		this.type = type;
	}
	
	public RoleType getType() {
		return type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}
	
}
