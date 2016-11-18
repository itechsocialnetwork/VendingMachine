package com.test.java.data.dao;

import org.springframework.stereotype.Repository;

import com.test.java.data.entity.Person;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person, Long> implements PersonDao {

}
