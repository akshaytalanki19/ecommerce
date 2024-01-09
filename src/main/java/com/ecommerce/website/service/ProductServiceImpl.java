package com.ecommerce.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.model.Product;
import com.ecommerce.website.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
	@Override
	public void insertProduct(Product p) {
		productRepository.save(p);
		
	}
	@Override
	public List<Product> getItems() {
		return productRepository.getAll();
		
	}
	@Override
	public Product ViewProductByID(int pid) {
		return productRepository.findById(pid).get();
	}
	
	

}
