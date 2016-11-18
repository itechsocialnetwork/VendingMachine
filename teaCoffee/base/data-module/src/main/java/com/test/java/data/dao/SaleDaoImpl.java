package com.test.java.data.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.java.data.entity.Coffee;
import com.test.java.data.entity.Container;
import com.test.java.data.entity.Item;
import com.test.java.data.entity.Sale;
import com.test.java.data.entity.Tea;

@Repository
public class SaleDaoImpl extends GenericDaoImpl<Sale, Integer> implements SaleDao {

	@Override
	public Criteria getSaleDetailByItemIdCriteria(Integer itemId) {
		
		return getCriteria().add(Restrictions.eq("item.id", itemId));
	}

	
}
