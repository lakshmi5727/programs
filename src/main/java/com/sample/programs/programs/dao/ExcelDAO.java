package com.sample.programs.programs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.programs.programs.model.ExcelModel;

public interface ExcelDAO extends JpaRepository<ExcelModel, Long> {
	
	

}
