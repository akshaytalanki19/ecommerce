package com.ecommerce.website.service;

import com.ecommerce.website.model.Reatiler;

public interface ReatilerService {
	public String insertReatiler(Reatiler r);

	public Reatiler checkreatiler(String email, String pwd);

}
