package com.test.java.data.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDto {

	private Long			studentId;
	private String			studentName;
	private List<SportDto>	sportsDto	= new ArrayList<SportDto>();

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<SportDto> getSportsDto() {
		return sportsDto;
	}

	public void setSportsDto(List<SportDto> sportsDto) {
		this.sportsDto = sportsDto;
	}

}
