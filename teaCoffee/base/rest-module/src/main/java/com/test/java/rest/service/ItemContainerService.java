package com.test.java.rest.service;

import java.util.List;

import com.test.java.data.entity.ItemContainer;
import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.form.Material;

public interface ItemContainerService {

	public List<ItemContainer> getAllitemContainers();
	
	public Object refillContainers() throws InstanceNotFoundException;
}
