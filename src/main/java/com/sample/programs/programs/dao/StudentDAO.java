package com.sample.programs.programs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.programs.programs.model.Student;

public interface StudentDAO extends JpaRepository<Student, Long> {

}
