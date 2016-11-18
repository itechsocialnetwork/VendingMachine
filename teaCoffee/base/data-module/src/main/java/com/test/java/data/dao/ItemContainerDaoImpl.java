package com.test.java.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.test.java.data.constant.ContainerConstant;
import com.test.java.data.entity.Coffee;
import com.test.java.data.entity.Container;
import com.test.java.data.entity.ItemContainer;
import com.test.java.data.entity.Tea;
import com.test.java.data.exception.InstanceNotFoundException;

@Repository
public class ItemContainerDaoImpl extends GenericDaoImpl<ItemContainer, Integer> implements ItemContainerDao {

	@Override
	public Criteria getContainerByNameCriteria(String containerName) {
		 return getCriteria().add(Restrictions.eq("name", containerName));
	}

	@Override
	public Object refillContainers() throws InstanceNotFoundException {

		@SuppressWarnings("unchecked")
		List<Integer> ids =  getCriteria()
		        .setProjection(Projections.property("id"))
		        .list();
		for(Integer id : ids)
		{
			ItemContainer itemContainer = find(id);
			String name = itemContainer.getName();
			switch (name) {
			case "TeaContainer":
				itemContainer.setCapacity(ContainerConstant.TeaContainer);
				update(itemContainer);
				break;
			case "CoffeeContainer":
				itemContainer.setCapacity(ContainerConstant.CoffeeContainer);
				update(itemContainer);
				break;
			case "SugarContainer":
				itemContainer.setCapacity(ContainerConstant.SugarContainer);
				update(itemContainer);
				break;
			case "WaterContainer":
				itemContainer.setCapacity(ContainerConstant.WaterContainer);
				update(itemContainer);
				break;
			case "MilkContainer":
				itemContainer.setCapacity(ContainerConstant.MilkContainer);
				update(itemContainer);
				break;
			default:
				break;
			}
		}
		return getEntities();
	}

}
