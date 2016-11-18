package com.test.java.rest.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

@RestController
@RequestMapping("/vending-machine")
public class ContainerController {

	private Logger		LOGGER	= LoggerFactory.getLogger(ContainerController.class);

	@Autowired
	private ItemContainerService itemContainerService;
	@ResponseBody
	@RequestMapping(value = "/initiate", method = RequestMethod.POST)
	public Object initiate(@RequestBody  Material material, BindingResult result,
	        HttpServletResponse response) {

		return "filled Successfully";

	}
	
	@ResponseBody
	@RequestMapping(value = "/containers", method = RequestMethod.GET)
	public Object getAllItems()
	{
		
		return itemContainerService.getAllitemContainers();
		
	}

	@ResponseBody
	@RequestMapping(value = "/refill-containers", method = RequestMethod.GET)
	public Object refillContainer(HttpServletResponse response) throws InstanceNotFoundException
	{
		Object data = null;
		try
		{
			data = itemContainerService.refillContainers();
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
