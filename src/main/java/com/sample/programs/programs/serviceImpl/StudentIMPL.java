package com.sample.programs.programs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sample.programs.programs.dao.StudentDAO;
import com.sample.programs.programs.dto.Result;
import com.sample.programs.programs.dto.StudentDTO;
import com.sample.programs.programs.mapper.ObjectMapper;
import com.sample.programs.programs.model.Student;
import com.sample.programs.programs.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentIMPL implements StudentService {
	
	/** The mapper. */
	private ObjectMapper MAPPER = ObjectMapper.INSTANCE;

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Result saveStudent(StudentDTO studentDto) {
		Result result = null;
		try {
			Student stu = new Student();
			StudentDTO stusave = MAPPER.fromStrdentDTOModel(studentDAO.save(stu));
			result.setData(stusave);
			if (stusave != null) {
				result.setStatusCode(HttpStatus.OK.value());
				result.setSuccessMessage("student saved successfully");
			} else {
				result.setStatusCode(HttpStatus.NOT_FOUND.value());
				result.setErrorMessage("student does't saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
