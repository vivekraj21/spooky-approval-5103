package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao aDao;
	
}
