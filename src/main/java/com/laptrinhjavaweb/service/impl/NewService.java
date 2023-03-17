package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.ICategoryRepository;
import com.laptrinhjavaweb.repository.INewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private INewRepository newRepository;

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter  newConverter;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		// TODO Auto-generated method stub
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public NewDTO update(NewDTO newDTO) {
		// TODO Auto-generated method stub
		NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
		NewEntity newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity); 
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id : ids) {
			newRepository.delete(id);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities= newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : entities) {
			NewDTO newDTO = newConverter.toDTO(newEntity);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> findAll() {
		// TODO Auto-generated method stub
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity newEntity : entities) {
			NewDTO newDTO = newConverter.toDTO(newEntity);
			results.add(newDTO);
		}
		return results;
	}
	
}
