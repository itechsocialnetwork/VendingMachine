package com.test.java.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.java.data.dao.PersonDao;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	@Transactional
	public void save() {
		/*
		 * Person person = new Person(); // person.setId(1L); person.setName("V");
		 * personDao.save(person);
		 */

	}

}
