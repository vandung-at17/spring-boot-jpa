package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id; 
	
	@Getter
	@Setter
	@Column (name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column (name = "modifiedby")
	@Getter
	@Setter
	@LastModifiedBy
	private String modifiedBy;
	
	@Column(name = "createddate")
	@Getter
	@Setter
	@CreatedDate
	private Date createdDate;
	
	@Column (name = "modifieddate")
	@Getter
	@Setter
	@LastModifiedDate
	private Date modifiedDate;
}
