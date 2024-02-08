package com.ecommerce.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.website.model.Reatiler;
import com.ecommerce.website.repository.ReatilerRepository;

@Service
public class ReatilerServiceImpl implements ReatilerService {

	@Autowired
	private ReatilerRepository reatilerRepository;
	@Autowired  // If using Spring
	private JdbcTemplate jdbcTemplate;
	@Override
	public String insertReatiler(Reatiler r) {
		reatilerRepository.save(r);
		return "deatils saved";
	}
	@Override
	public Reatiler checkreatiler(String email, String pwd) {
		return reatilerRepository.checkreatiler(email,pwd);
	
	}
	@Override
	public List<Reatiler> viewReatiler() {
		
		return reatilerRepository.findAll();
	}
	@Override
	public long getCount() {
		
		return reatilerRepository.count();
	}
	
	

}