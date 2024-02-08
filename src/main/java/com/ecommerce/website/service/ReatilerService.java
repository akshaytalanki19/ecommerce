package com.ecommerce.website.service;

import java.util.List;

import com.ecommerce.website.model.Reatiler;

public interface ReatilerService {
	public String insertReatiler(Reatiler r);

	public Reatiler checkreatiler(String email, String pwd);

	public List<Reatiler> viewReatiler();

	public long getCount();

}
