package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (name = "role")
@Data
@EqualsAndHashCode(callSuper=false)
public class RoleEntity extends BaseEntity{
	
	@Column(name = "code", unique = true)
	@NotNull
	private String code;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<UserEntity>();
}
