package com.ecommerce.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.model.Admin;
import com.ecommerce.website.model.Reatiler;
import com.ecommerce.website.model.User;
import com.ecommerce.website.repository.AdminRepository;
import com.ecommerce.website.repository.CustomerRepository;
import com.ecommerce.website.repository.ReatilerRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReatilerRepository reatilerRepository;
	@Override
	public Admin checkadminlogin(String auname, String apwd) {
		return adminRepository.checkadminlogin(auname,apwd);
		
	}
	@Override
	public List<User> viewUsers() {
		
		return customerRepository.findAll();
	}
	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}
	@Override
	public void deleteReatiler(int id) {
		reatilerRepository.deleteById(id);
	}
	@Override
	public List<Reatiler> viewReatiler() {
		return reatilerRepository.findAll();
	}
	@Override
	public long getCount() {
		return customerRepository.count();
	}
	
}