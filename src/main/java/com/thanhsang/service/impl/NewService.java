package com.thanhsang.service.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhsang.converter.NewConverter;
import com.thanhsang.dto.NewDTO;
import com.thanhsang.entity.CategoryEntity;
import com.thanhsang.entity.NewEntity;
import com.thanhsang.repository.CategoryRepository;
import com.thanhsang.repository.NewRepository;
import com.thanhsang.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
 
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId()!=null) {
			NewEntity oldNewEntity = entityManager.find(NewEntity.class, newDTO.getId());
			newEntity = newConverter.toEntity(newDTO,oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public NewDTO delete(long id) {
		NewEntity newEntity = entityManager.find(NewEntity.class, id);
		if (newEntity!=null) {
			NewDTO newDTO = newConverter.toDTO(newEntity);
			newRepository.deleteById(id);
			return newDTO;
		}else {
			return null;
		}	
	}

}
