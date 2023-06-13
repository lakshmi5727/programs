//package com.sample.programs.programs.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//
//
//import com.sample.programs.programs.dao.ExcelDAO;
//import com.sample.programs.programs.dto.ExcelDTO;
//import com.sample.programs.programs.dto.Result;
//import com.sample.programs.programs.mapper.ObjectMapper;
//import com.sample.programs.programs.model.ExcelModel;
//import com.sample.programs.programs.service.ExcelService;
//
//public class ExcelDataSave implements ExcelService {
//
//	@Autowired
//	private ExcelDAO excelDAO;
//	
//	  private ObjectMapper MAPPER = ObjectMapper.INSTANCE;
//
//	
//	@Override
//	public Result saveExcel(List<ExcelDTO> excelDTO) {
//		
//		Result result = null;
//		try { 
//		     List<ExcelModel> records = MAPPER.fromExcelDTO(excelDTO);
//		     List<ExcelModel> serverStudents = excelDAO.saveAll(records);
//	        	result = new Result(serverStudents);
//	        	result.setStatusCode(HttpStatus.OK.value());
//	     	    result.setSuccessMessage("students saved succussfully.");
//		    } catch (Exception e) {
//		           e.printStackTrace();
//		      }
//		return result;
//		
//	}
//	
//	
//	
//	
//	
//}

	
//	@Override

//	public Result saveExcel(List<ExcelDTO> ExcelDTOs) {
//
//	Result result = null;
//	try { 
//	     List<ExcelModel> students = MAPPER.fromExcelModel(ExcelDTOs);
//	     List<ExcelModel> serverStudents = ExcelDAO.saveAll(students);
//        	result = new Result(serverStudents);
//        	result.setStatusCode(HttpStatus.OK.value());
//     	    result.setSuccessMessage("students saved succussfully.");
//	    } catch (Exception e) {
//	           throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	      }
//	return result;
//
//	}


