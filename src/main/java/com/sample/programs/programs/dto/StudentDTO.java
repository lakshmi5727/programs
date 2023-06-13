package com.sample.programs.programs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private Long studentId;
	private String stuFirstName;
	private String stuLastName;
	private String DOB;
	private String gender;
	private String city;
	private String state;
	private String Country;
	private String pName;
	private String pEmail;
	private String pPhoneNo;
	private String stateDate;
	private String endDate;
}
