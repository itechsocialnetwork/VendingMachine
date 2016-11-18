package com.test.java.rest.service;

import java.util.List;

import com.test.java.data.entity.WasteMaterial;
import com.test.java.data.exception.InstanceNotFoundException;

public interface WasteService {
	
	List<WasteMaterial> getWasteMaterialData();
	public Object getTotalWastePerProduct(String type) throws InstanceNotFoundException;

}
