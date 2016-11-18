package com.test.java.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.java.data.dao.ItemContainerDao;
import com.test.java.data.dao.ItemDao;
import com.test.java.data.dao.SaleDao;
import com.test.java.data.dao.WasteMaterialDao;
import com.test.java.data.entity.Item;
import com.test.java.data.entity.ItemContainer;
import com.test.java.data.entity.Sale;
import com.test.java.data.entity.WasteMaterial;
import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.exception.ContainerEmptyException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private ItemContainerDao itemContainerDao;
	
	@Autowired
	private WasteMaterialDao wasteMaterialDao;
	
	@Autowired
	private SaleDao saleDao;
	

	@Override
	@Transactional
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemDao.getEntities();
	}

	@Override
	@Transactional
	/*Making coffee and returning total price*/
	public Integer makeCoffee(String name, Integer count) throws InstanceNotFoundException, ContainerEmptyException {
		Integer cost = 0;
		Item item = (Item) itemDao.getByCriteria(itemDao.getFindByItemnameCriteria(name));

		if (item.getName().equalsIgnoreCase("BlackCoffee")) {

			int sugar = count * 15;
			int water = count * 100;
			int coffee = count * 3;
			int waste = count*1;
			int wasteCoffee = 0;
			int wasteWater = 12000*count;
			int wasteSugar = 2000*count;
			int wasteMilk = 0;
			if (checkContainerForTeaAndCoffee(sugar, water, 0,coffee,0,"BlackCoffee")) {
				updateWasteStatus("Water", wasteWater);
				updateWasteStatus("Sugar", wasteSugar);
				
				updateContainer("WaterContainer", water);
				updateContainer("SugarContainer", sugar);
				
				updateSales(item.getId(), item.getCount());
				
				
				cost = count * 10;
			}
			else throw new ContainerEmptyException("Container Empty");
		}

		else if (name.equalsIgnoreCase("Coffee")) {
			int sugar = count * 15;
			int water = count * 100;
			int coffee = count*80;
			int milk = count*80;
			int wasteCoffee = 1000*count;
			int wasteWater = 3000*count;
			int wasteSugar = 2000*count;
			int wasteMilk = 8000*count;
			if (checkContainerForTeaAndCoffee(sugar, water, 0,coffee,milk,"Coffee")) {
				cost = count * 10;
				updateWasteStatus("Water", wasteWater);
				updateWasteStatus("Sugar", wasteSugar);
				updateWasteStatus("Coffee", wasteCoffee);
				updateWasteStatus("Milk", wasteMilk);
			
				updateContainer("CoffeeContainer", coffee);
				updateContainer("WaterContainer", water);
				updateContainer("SugarContainer", sugar);
				updateContainer("MilkContainer", milk);
				updateSales(item.getId(), item.getCount());
				
			}
			else throw new ContainerEmptyException("Container Empty");
		}

		item.setCount(item.getCount() + count);
		itemDao.update(item);
		
		return cost;
	}

	@Override
	@Transactional
	/*Making tea and returning total price*/
	public Integer makeTea(String name, Integer count) throws InstanceNotFoundException, ContainerEmptyException {
		Integer cost = 0;
		Item item = (Item) itemDao.getByCriteria(itemDao.getFindByItemnameCriteria(name));
		if (name.equalsIgnoreCase("BlackTea")) {
			int sugar = count * 15;
			int water = count * 100;
			int tea = count * 3;
			int milk = count * 40;
			int wasteTea = 0;
			int wasteWater = 12000*count;
			int wasteSugar = 2000*count;
			if (checkContainerForTeaAndCoffee(sugar, water, tea,0,0,"BlackTea")) {
				cost = count * 10;
				updateWasteStatus("Water", wasteWater);
				updateWasteStatus("Sugar", wasteSugar);
				
				updateContainer("WaterContainer", water);
				updateContainer("SugarContainer", sugar);
				updateSales(item.getId(), item.getCount());
				
			}
			else throw new ContainerEmptyException("Container Empty");

		}

		else if (name.equalsIgnoreCase("Tea")) {
			
			int sugar = count * 15;
			int water = count * 60;
			int tea = count * 5;
			int milk = count*40;
			int wasteTea = 0;
			int wasteWater = 12000*count;
			int wasteSugar = 2000*count;
			int wasteMilk = 2000*count;
			if(checkContainerForTeaAndCoffee(sugar, water, tea, 0, milk, "Tea"))
			{
				cost = count * 15;
				updateWasteStatus("Tea", wasteWater);   
				updateWasteStatus("Water", wasteWater);
				updateWasteStatus("Sugar", wasteSugar);
				updateWasteStatus("Milk", wasteMilk);
				
				updateContainer("TeaContainer", tea);
				updateContainer("WaterContainer", water);
				updateContainer("SugarContainer", sugar);
				updateContainer("MilkContainer", milk);
				
				updateSales(item.getId(), item.getCount());
				
			}
			else throw new ContainerEmptyException("Container Empty");
		}

		item.setCount(count);
		item.setCount(item.getCount() + count);
		return cost;
	}


    /*Checking whether containers have suffient material or not*/
	private boolean checkContainerForTeaAndCoffee(Integer sugar, Integer water, Integer tea, Integer coffee,Integer milk,String drinkType)
			throws InstanceNotFoundException {
		boolean result = true;
		ItemContainer itemContainerWater = (ItemContainer) itemContainerDao
				.getByCriteria(itemContainerDao.getContainerByNameCriteria("WaterContainer"));
		if (itemContainerWater.getCapacity() < water) {
			result = false;
			return result;
		}

		ItemContainer itemContainerSugar = (ItemContainer) itemContainerDao
				.getByCriteria(itemContainerDao.getContainerByNameCriteria("SugarContainer"));
		if (itemContainerSugar.getCapacity() < sugar) {
			result = false;
			return result;
		}

		ItemContainer itemContainerTea = (ItemContainer) itemContainerDao
				.getByCriteria(itemContainerDao.getContainerByNameCriteria("TeaContainer"));
		if (itemContainerTea.getCapacity() < tea) {
			result = false;
			return result;
		}

		ItemContainer itemContainerMilk = (ItemContainer) itemContainerDao
				.getByCriteria(itemContainerDao.getContainerByNameCriteria("MilkContainer"));
		if (itemContainerMilk.getCapacity() < milk) {
			result = false;
			return result;
		}
		return result;

	}

	/*	Updating Waste Material status*/
	private void updateWasteStatus(String type, int waste) throws InstanceNotFoundException
	{
		WasteMaterial wasteMaterial = (WasteMaterial) wasteMaterialDao.getByCriteria(wasteMaterialDao.getFindByWastenameCriteria(type));
		wasteMaterial.setValue(waste);
		wasteMaterialDao.update(wasteMaterial);
	}
	
     /*	Updating Containers*/
	private void updateContainer(String type, int value) throws InstanceNotFoundException
	{
		ItemContainer itemContainer = (ItemContainer) itemContainerDao
				.getByCriteria(itemContainerDao.getContainerByNameCriteria(type));
		itemContainer.setCapacity(itemContainer.getCapacity() - value);
		itemContainerDao.update(itemContainer);
		
	}

	@Override
	@Transactional
	public Integer totalSale(String drinkType) throws InstanceNotFoundException {
		Item item = (Item) itemDao.getByCriteria(itemDao.getFindByItemnameCriteria(drinkType));
		int totalCostOfItem = item.getCount()*(item.getCost());
		return totalCostOfItem;
	}

	@Override
	@Transactional
	public Long totalSoldItems() {
		Long  totalSoldItems = (Long) itemDao.getTotalSumOfItems().uniqueResult();
		return totalSoldItems;
	}
	
	private void  updateSales(Integer itemId,Integer count) throws InstanceNotFoundException
	{
		Sale  sale = (Sale) saleDao.getByCriteria(saleDao.getSaleDetailByItemIdCriteria(itemId));
		Item item = itemDao.find(itemId);
		sale.setItem(item);
		sale.setTotalSum(count*item.getCost());
		saleDao.update(sale);
	}
}
