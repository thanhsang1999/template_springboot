package com.thanhsang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanhsang.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

	NewEntity findByTitle(String title);
}
