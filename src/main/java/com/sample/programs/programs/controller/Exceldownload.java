package com.sample.programs.programs.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.programs.programs.dao.ExcelDAO;
import com.sample.programs.programs.model.ExcelModel;



@RestController
@RequestMapping("/api/v1")

public class Exceldownload {
	
	@Autowired
	private ExcelDAO excelDAO;
//	
//	@Autowired
//	private ExcelService excelService;
	
	 @GetMapping("/export")
	    public ResponseEntity<ByteArrayResource> exportExcelFile() throws IOException {
	        // Create a workbook using the SXSSF implementation
	        try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
	            // Create a sheet in the workbook
	            Sheet sheet = workbook.createSheet("Data");

	            // Retrieve data from the database
	            List<ExcelModel> excelModels = excelDAO.findAll();

	            String[] HEADERs = {"id", "name", "email", "gender", "ph_num"};

	            Row row = sheet.createRow(0);

	            int cellId = 0;
	            for (String string : HEADERs) {
	                Cell cell = row.createCell(cellId++);
	                cell.setCellValue(string);
	            }

	            // Write data to the Excel sheet
	            int rowIndex = 1; // Start from the second row
	            for (ExcelModel excelModel : excelModels) {
	                row = sheet.createRow(rowIndex++);
	                Cell cell = row.createCell(0);
	                cell.setCellValue(excelModel.getId());

	                cell = row.createCell(1);
	                cell.setCellValue(excelModel.getName());

	                cell = row.createCell(2);
	                cell.setCellValue(excelModel.getEmail());

	                cell = row.createCell(3);
	                cell.setCellValue(excelModel.getGender());

	                cell = row.createCell(4);
	                cell.setCellValue(excelModel.getPhNum());
	            }

	            // Generate the Excel file
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            workbook.write(outputStream);

	            // Convert the Excel file to a byte array
	            byte[] excelBytes = outputStream.toByteArray();

	            // Create a ByteArrayResource from the byte array
	            ByteArrayResource resource = new ByteArrayResource(excelBytes);

	            // Set the response headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"example.xlsx\"");
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

	            // Return the Excel file as a ResponseEntity
	            return ResponseEntity.ok()
	                    .headers(headers)
	                    .contentLength(excelBytes.length)
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .body(resource);
	        }
	    }
	 
//	 /**
//	   * saving saveExcel
//	   *
//	   * @param ExcelDTO excelDTO
//	   * @return the ExcelModel
//	   */
//	 @PostMapping("/seve-excel")
//	  public ResponseEntity<Result> saveExcel(@RequestBody List<ExcelDTO> excelDTO) {
//	    return ResponseEntity.ok(excelService.saveExcel(excelDTO));
//	  }
	
}



	
