package com.sample.programs.programs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.programs.programs.dto.StudentDTO;
import com.sample.programs.programs.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/billingfees")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public ResponseEntity<?> getbillingFee(@RequestBody StudentDTO studentDTO) {
		return ResponseEntity.ok(studentService.saveStudent(studentDTO));
	}

}
