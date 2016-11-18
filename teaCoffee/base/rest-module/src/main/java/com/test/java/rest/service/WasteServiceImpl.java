package com.test.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.java.data.dao.WasteMaterialDao;
import com.test.java.data.entity.WasteMaterial;
import com.test.java.data.exception.InstanceNotFoundException;

@Service
public class WasteServiceImpl implements WasteService {
	
	@Autowired
	private WasteMaterialDao wasteMaterialDao;

	@Override
	public List<WasteMaterial> getWasteMaterialData() {
		return wasteMaterialDao.getEntities();
	}

	@Override
	@Transactional
	public Object getTotalWastePerProduct(String type) throws InstanceNotFoundException {
		WasteMaterial wasteMaterial = (WasteMaterial) wasteMaterialDao.getByCriteria(wasteMaterialDao.getFindByWastenameCriteria(type));
		
		return wasteMaterial.getValue();
	}
	
	

}
