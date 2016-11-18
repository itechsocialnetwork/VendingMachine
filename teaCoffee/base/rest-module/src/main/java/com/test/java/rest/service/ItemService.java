package com.test.java.rest.service;

import java.util.List;

import com.test.java.data.entity.Item;
import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.exception.ContainerEmptyException;

public interface ItemService {
	
	public List<Item> getAllItems();
	
	public Integer makeCoffee(String name,Integer count) throws InstanceNotFoundException, ContainerEmptyException;
	
	public Integer makeTea(String name,Integer count) throws InstanceNotFoundException, ContainerEmptyException;
	
	public Integer totalSale(String drinkType) throws InstanceNotFoundException;
	
	public Long totalSoldItems();
	

}
