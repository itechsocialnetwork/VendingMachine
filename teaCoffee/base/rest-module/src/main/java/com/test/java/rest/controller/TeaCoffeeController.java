package com.test.java.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.constant.ErrorCodes;
import com.test.java.rest.exception.ContainerEmptyException;
import com.test.java.rest.exception.DatabaseException;
import com.test.java.rest.model.ErrorResponse;
import com.test.java.rest.service.ItemService;

@RestController
@RequestMapping("/vending-machine")
public class TeaCoffeeController {

	@Autowired
	ItemService itemService;
	
	private Logger		LOGGER	= LoggerFactory.getLogger(TeaCoffeeController.class);

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public Object getAllItems() {

		return itemService.getAllItems();

	}

	@ResponseBody
	@RequestMapping(value = "/coffee/{type}/{count}", method = RequestMethod.GET)
	public Object orderCoffee(@PathVariable String type,@PathVariable Integer count,HttpServletResponse response) 
			throws InstanceNotFoundException, ContainerEmptyException, DatabaseException
	{
		Object data = null;
		try {
			data = itemService.makeCoffee(type, count);
		} catch (Exception e) {
			LOGGER.error("Exception" + e.getMessage(), e);
			((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
			((ErrorResponse) data).setMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return data;
	}

		

	@ResponseBody
	@RequestMapping(value = "/tea/{type}/{count}", method = RequestMethod.GET)
	public Object orderTea(@PathVariable String type, @PathVariable Integer count,HttpServletResponse response)
			throws InstanceNotFoundException, ContainerEmptyException,DatabaseException {

		{
			Object data = null;
			try {
				data = itemService.makeTea(type, count);
			} catch (Exception e) {
				LOGGER.error("Exception" + e.getMessage(), e);
				((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
				((ErrorResponse) data).setMessage(e.getMessage());
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return data;
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "item/{type}", method = RequestMethod.GET)
	public Object totalSaleofProduct(@PathVariable String type,HttpServletResponse response)
			throws InstanceNotFoundException, ContainerEmptyException,DatabaseException {

		{
			Object data = null;
			try {
				data = itemService.totalSale(type);
			} catch (Exception e) {
				LOGGER.error("Exception" + e.getMessage(), e);
				((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
				((ErrorResponse) data).setMessage(e.getMessage());
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return data;
		}

	}

	@RequestMapping(value = "/sold-items", method = RequestMethod.GET)
	public Object getTotalSoldItems(HttpServletResponse response) {

		Object data = null;
		try
		{
			data = itemService.totalSoldItems();
		}
		
		catch (Exception e) {
			LOGGER.error("Exception" + e.getMessage(), e);
			((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
			((ErrorResponse) data).setMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return data;
	} 

}
