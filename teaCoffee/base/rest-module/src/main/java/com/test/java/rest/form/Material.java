package com.test.java.rest.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.test.java.rest.constant.ErrorCodes;

public class Material {

	
	private Integer	tea;

	
	private Integer	coffee;

	
	private Integer	sugar;

	
	private Integer	water;

	
	private Integer	milk;

	public Integer getTea() {
		return tea;
	}

	public void setTea(Integer tea) {
		this.tea = tea;
	}

	public Integer getCoffee() {
		return coffee;
	}

	public void setCoffee(Integer coffee) {
		this.coffee = coffee;
	}

	public Integer getSugar() {
		return sugar;
	}

	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}

	public Integer getWater() {
		return water;
	}

	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getMilk() {
		return milk;
	}

	public void setMilk(Integer milk) {
		this.milk = milk;
	}

}
