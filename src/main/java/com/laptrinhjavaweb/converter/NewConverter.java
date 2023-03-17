package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity(); 
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setContent(newDTO.getContent());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setThumbnail(newDTO.getThumbnail());
		return newEntity;
	}
	
	public NewDTO toDTO (NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		if (newEntity.getId() != null) {
			newDTO.setId(newEntity.getId());
		}
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setContent(newEntity.getContent());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setThumbnail(newDTO.getThumbnail());
		newDTO.setCreatedDate(newEntity.getCreatedDate());
		newDTO.setCreatedBy(newEntity.getCreatedBy());
		newDTO.setModifiedDate(newEntity.getModifiedDate());
		newDTO.setModifiedBy(newEntity.getModifiedBy());
		return newDTO;
	}
	public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity) {
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setContent(newDTO.getContent());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setThumbnail(newDTO.getThumbnail());
		return newEntity;
	}
}
