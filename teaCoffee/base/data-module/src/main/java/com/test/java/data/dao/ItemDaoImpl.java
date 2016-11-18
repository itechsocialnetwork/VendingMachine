package com.test.java.data.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.java.data.entity.Coffee;
import com.test.java.data.entity.Container;
import com.test.java.data.entity.Item;
import com.test.java.data.entity.Tea;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item, Integer> implements ItemDao {

	@Override
	public Criteria getFindByItemnameCriteria(String itemName) {
		return getCriteria().add(Restrictions.eq("name", itemName));
	}

	@Override
	public Criteria getTotalSumOfItems() {
		return getCriteria().setProjection(Projections.sum("count"));
	}

}
