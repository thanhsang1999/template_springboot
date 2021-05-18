package com.thanhsang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanhsang.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
