package com.test.java.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale {
	
	private Integer id;
	private Item item;
	private Integer totalSum;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne
    @JoinColumn(name="item_id")
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	@Column(name = "total_sum")
	public Integer getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(Integer totalSum) {
		this.totalSum = totalSum;
	}
	
	
	
	

}
