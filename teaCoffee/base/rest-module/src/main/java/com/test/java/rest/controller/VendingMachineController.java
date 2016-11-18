package com.test.java.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.rest.service.PersonService;

@RestController
@RequestMapping("/vending-machine")
public class VendingMachineController {

	private Logger			LOGGER	= LoggerFactory.getLogger(VendingMachineController.class);

	@Autowired
	private PersonService	personService;

	@Autowired

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public Object welcome() {
		personService.save();
		return "Welcome Guest, What would you like to have ?";
	}

	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public Object exit() {
		LOGGER.info(">> createEntity");
		personService.save();
		return "Thanks for using service, Visit again";
	}
}
