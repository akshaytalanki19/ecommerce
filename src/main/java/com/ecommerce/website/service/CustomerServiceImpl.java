package com.ecommerce.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.model.User;
import com.ecommerce.website.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	@Override
	public String insercustomer(User c) {
		
		 customerRepository.save(c);
		 return null;
	}
	@Override
	public User checkuserlogin(String name, String pwd) {
		
		return customerRepository.checkuserlogin(name,pwd);
	}
	@Override
	public long getCount() {
		return customerRepository.count();
	}
	
}
