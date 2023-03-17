package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{
	@Column(name = "name", unique = true) 
	private String name;
	
	@Column(name = "code", unique = true)
	private String code;
	
	@OneToMany(mappedBy = "category")
	private List<NewEntity> news = new ArrayList<>();
}
