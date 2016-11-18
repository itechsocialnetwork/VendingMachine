package com.test.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.java.data.dao.ItemContainerDao;
import com.test.java.data.entity.Item;
import com.test.java.data.entity.ItemContainer;
import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.form.Material;

@Service
public class ItemContainerServiceImpl implements ItemContainerService{
	
	@Autowired
	ItemContainerDao itemContainerDao;

	@Override
	public List<ItemContainer> getAllitemContainers() {
		
		return itemContainerDao.getEntities();
	}

	@Override
	@Transactional
	public Object refillContainers() throws InstanceNotFoundException {
		
		return itemContainerDao.refillContainers();
		
		
	}

	
	
}
