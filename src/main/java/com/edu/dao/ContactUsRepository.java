package com.edu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.entity.ContactUs;

@Repository
public interface ContactUsRepository extends CrudRepository<ContactUs, Integer> {

}
