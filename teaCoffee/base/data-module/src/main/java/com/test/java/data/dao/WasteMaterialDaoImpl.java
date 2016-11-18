package com.test.java.data.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.java.data.entity.WasteMaterial;

@Repository
public class WasteMaterialDaoImpl extends GenericDaoImpl<WasteMaterial, Integer> implements WasteMaterialDao {

	@Override
	public Criteria getFindByWastenameCriteria(String wasteMaterialName) {
	 return getCriteria().add(Restrictions.eq("name", wasteMaterialName));
	}

}