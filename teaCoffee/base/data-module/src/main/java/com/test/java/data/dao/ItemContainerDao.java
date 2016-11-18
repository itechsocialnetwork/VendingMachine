package com.test.java.data.dao;

import org.hibernate.Criteria;

import com.test.java.data.entity.Coffee;
import com.test.java.data.entity.Container;
import com.test.java.data.entity.ItemContainer;
import com.test.java.data.exception.InstanceNotFoundException;

public interface ItemContainerDao extends GenericDao<ItemContainer, Integer> {
	
	Criteria getContainerByNameCriteria(String containerName);
    Object refillContainers() throws InstanceNotFoundException;
	
}
