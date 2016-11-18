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
@RequestMapping("/tests")
public class TestController {

	private Logger			LOGGER	= LoggerFactory.getLogger(TestController.class);

	@Autowired
	private PersonService	personService;

	@Autowired

	@RequestMapping(value = "/create-person", method = RequestMethod.GET)
	public Object createEntity() {
		LOGGER.info(">> createEntity");
		personService.save();
		return "person saved";
	}

	
}
