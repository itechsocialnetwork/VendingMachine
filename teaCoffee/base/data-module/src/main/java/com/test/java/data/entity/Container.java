package com.test.java.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "container")
public class Container {

	private Integer	id;
	private Integer	teaContainer;
	private Integer	coffeeContainer;
	private Integer	sugarContainer;
	private Integer	waterContainer;
	private Integer	milkContainer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "tea")
	public Integer getTeaContainer() {
		return teaContainer;
	}

	public void setTeaContainer(Integer teaContainer) {
		this.teaContainer = teaContainer;
	}

	@Column(name = "coffee")
	public Integer getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(Integer coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}

	@Column(name = "sugar")
	public Integer getSugarContainer() {
		return sugarContainer;
	}

	public void setSugarContainer(Integer sugarContainer) {
		this.sugarContainer = sugarContainer;
	}

	@Column(name = "water")
	public Integer getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(Integer waterContainer) {
		this.waterContainer = waterContainer;
	}

	@Column(name = "milk")
	public Integer getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(Integer milkContainer) {
		this.milkContainer = milkContainer;
	}

}
