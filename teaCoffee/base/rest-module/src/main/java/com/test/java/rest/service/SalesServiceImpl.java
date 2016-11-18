package com.test.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.java.data.dao.ItemDao;
import com.test.java.data.dao.SaleDao;
import com.test.java.data.entity.Item;
import com.test.java.data.exception.InstanceNotFoundException;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private SaleDao saleDao;
	
	@Override
	public Object getAllSales() {
		
		return saleDao.getEntities();
	}
	@Override
	@Transactional
	public Object getSaleById(Integer id) throws InstanceNotFoundException {
		return saleDao.getByCriteria(saleDao.getSaleDetailByItemIdCriteria(id));
	}

}
