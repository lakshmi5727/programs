package com.sample.programs.programs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String stuFirstName;
	private String stuLastName;
	private Date DOB;
	private String gender;
	private String city;
	private String state;
	private String Country;
	private String pName;
	private String pEmail;
	private String pPhoneNo;
	private Date stateDate;
	private Date endDate;

}

