package com.ecommerce.website.service;

import java.util.List;

import com.ecommerce.website.model.Admin;
import com.ecommerce.website.model.Reatiler;
import com.ecommerce.website.model.User;

public interface AdminService {
	 public Admin checkadminlogin(String auname,String apwd);

		public List<User> viewUsers();

		public void deleteById(int id);

		public void deleteReatiler(int id);

		public List<Reatiler> viewReatiler();

		public long getCount();
}
