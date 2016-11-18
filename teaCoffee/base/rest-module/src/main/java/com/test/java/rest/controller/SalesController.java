package com.test.java.rest.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.data.exception.InstanceNotFoundException;
import com.test.java.rest.constant.ErrorCodes;
import com.test.java.rest.form.*;
import com.test.java.rest.model.ErrorResponse;
import com.test.java.rest.service.ItemContainerService;
import com.test.java.rest.service.ItemService;
import com.test.java.rest.service.SalesService;

@RestController
@RequestMapping("/vending-machine/sales")
public class SalesController {

	private Logger		LOGGER	= LoggerFactory.getLogger(SalesController.class);

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SalesService saleService;

	@ResponseBody
	@RequestMapping( method = RequestMethod.GET)
	public Object getTotalSale(HttpServletResponse response) throws InstanceNotFoundException
	{
		Object data = null;
		try
		{
			data = saleService.getAllSales();
		}
		catch(Exception e) {
			LOGGER.error("Exception" + e.getMessage(), e);
			((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
			((ErrorResponse) data).setMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return data;
	} 

	
	@ResponseBody
	@RequestMapping(value = "/item-product/{id}", method = RequestMethod.GET)
	public Object getTotalSaleByProduct(@PathVariable Integer id,HttpServletResponse response) throws InstanceNotFoundException
	{
		Object data = null;
		try
		{
			data = saleService.getSaleById(id);
		}
		catch(Exception e) {
			LOGGER.error("Exception" + e.getMessage(), e);
			((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
			((ErrorResponse) data).setMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return data;
	} 

}
