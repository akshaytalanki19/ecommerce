package com.ecommerce.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.model.Admin;
import com.ecommerce.website.model.User;
import com.ecommerce.website.repository.AdminRepository;
import com.ecommerce.website.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
	@Override
	public Admin checkadminlogin(String auname, String apwd) {
		return adminRepository.checkadminlogin(auname,apwd);
		
	}
	@Override
	public List<User> viewUsers() {
		
		return customerRepository.findAll();
	}
	
}