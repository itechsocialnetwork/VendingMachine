package com.test.java.data.dao;

import org.hibernate.Criteria;

import com.test.java.data.entity.Coffee;
import com.test.java.data.entity.Container;
import com.test.java.data.entity.Item;
import com.test.java.data.entity.Sale;
import com.test.java.data.entity.Tea;

public interface SaleDao extends GenericDao<Sale, Integer> {
	Criteria getSaleDetailByItemIdCriteria(Integer itemId);

}
