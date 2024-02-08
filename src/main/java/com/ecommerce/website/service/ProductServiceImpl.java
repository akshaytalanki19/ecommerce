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
	@Override
	public List<Product> getShoes() {
		return productRepository.getShoes();
	}
	@Override
	public List<Product> getTrend() {
		return productRepository.getTrend();
	}
	@Override
	public List<Product> getFruits() {
		return productRepository.getFruits();
	}
	@Override
	public List<Product> getBooks() {
		return productRepository.getBooks();
	}
	@Override
	public List<Product> getElectroncis() {
		return productRepository.getElectroncis();
	}
	@Override
	public List<Product> getGames() {
		return productRepository.getGames();
	}
	@Override
	public List<Product> getHome() {
		return productRepository.getHome();
	}
	@Override
	public List<Product> getToys() {
		return productRepository.getToys();
	}
	@Override
	public List<Product> getWatches() {
		return productRepository.getWatches();
	}
	@Override
	public List<Product> getHealth() {
		return productRepository.getHealth();
	}
	
	

}
