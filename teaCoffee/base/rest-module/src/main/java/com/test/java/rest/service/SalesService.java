package com.test.java.rest.service;

import com.test.java.data.exception.InstanceNotFoundException;

public interface SalesService {

	public Object getAllSales();
	
	public Object getSaleById(Integer id) throws InstanceNotFoundException;
}
