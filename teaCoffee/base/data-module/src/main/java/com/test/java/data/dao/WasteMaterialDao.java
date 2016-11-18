package com.test.java.data.dao;

import org.hibernate.Criteria;

import com.test.java.data.entity.WasteMaterial;

public interface WasteMaterialDao extends GenericDao<WasteMaterial, Integer> {
	
	Criteria getFindByWastenameCriteria(String itemName);

}
