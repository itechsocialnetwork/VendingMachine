package com.test.java.data.dto;

import java.util.ArrayList;
import java.util.List;

public class SportDto {

	private Long					sportId;
	private String					sportName;
	private List<SportCategoryDto>	sportsCategories	= new ArrayList<>();

	public Long getSportId() {
		return sportId;
	}

	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public List<SportCategoryDto> getSportsCategories() {
		return sportsCategories;
	}

	public void setSportsCategories(List<SportCategoryDto> sportsCategories) {
		this.sportsCategories = sportsCategories;
	}

}
