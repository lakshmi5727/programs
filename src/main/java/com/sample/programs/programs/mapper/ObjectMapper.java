package com.sample.programs.programs.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sample.programs.programs.dto.StudentDTO;
import com.sample.programs.programs.model.Student;

@Mapper(config = IgnoreUnMapperConfig.class)
public interface ObjectMapper {

	ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

//	ExcelDTO fromExcelModel(ExcelModel saveExcelRecords);
//	List<ExcelDTO> fromExcelModel(List<ExcelModel> excelModels);
//
//	ExcelModel fromExcelDTO(ExcelDTO excelDTO);
//	List<ExcelModel> fromExcelDTO(List<ExcelDTO> excelDTOs);

	@Mapping(source = "stateDate", target = "stateDate", dateFormat = "MM/dd/yyyy")
	@Mapping(source = "endDate", target = "endDate", dateFormat = "MM/dd/yyyy")
	@Mapping(source = "DOB", target = "DOB", dateFormat = "MM/dd/yyyy")
	StudentDTO fromStrdentDTOModel(Student student);
	List<StudentDTO> fromStrdentDTOModel(List<Student> student);
}
