package com.test.java.rest.controller;

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
import com.test.java.rest.service.WasteService;

@RestController
@RequestMapping("/vending-machine")
public class WasteController {
	
	@Autowired
	private WasteService wasteService;
	
	private Logger		LOGGER	= LoggerFactory.getLogger(WasteController.class);
	@RequestMapping(value = "/waste", method = RequestMethod.GET)
	public Object getAllWaste(HttpServletResponse response) {

		Object data = null;
		try {
			data = wasteService.getWasteMaterialData();
		} catch (Exception e) {
			LOGGER.error("Exception" + e.getMessage(), e);
			((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
			((ErrorResponse) data).setMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return data;

	}
	
	@ResponseBody
	@RequestMapping(value = "/waste-count/{type}", method = RequestMethod.GET)
	public Object totalSaleofProduct(@PathVariable String type,HttpServletResponse response)
			throws InstanceNotFoundException, ContainerEmptyException,DatabaseException {

		{
			Object data = null;
			try {
				data = wasteService.getTotalWastePerProduct(type);
			} catch (Exception e) {
				LOGGER.error("Exception" + e.getMessage(), e);
				((ErrorResponse) data).setErrorCode(ErrorCodes.SERVER_ERROR);
				((ErrorResponse) data).setMessage(e.getMessage());
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return data;
		}

	}

}
