package com.ecommerce.website.service;

import com.ecommerce.website.model.User;

public interface CustomerService {
	public String insercustomer(User u);
	public User checkuserlogin(String name, String pwd);
}
