package com.ecommerce.website.service;

import java.util.List;

import com.ecommerce.website.model.Admin;
import com.ecommerce.website.model.User;

public interface AdminService {
	 public Admin checkadminlogin(String auname,String apwd);

		public List<User> viewUsers();
}
