package com.sample.programs.programs.service;

import com.sample.programs.programs.dto.Result;
import com.sample.programs.programs.dto.StudentDTO;

public interface StudentService {
	
	Result saveStudent(StudentDTO studentDto);

}
