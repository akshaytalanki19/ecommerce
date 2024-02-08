package com.ecommerce.website.service;

import java.util.List;

import com.ecommerce.website.model.Product;

public interface ProductService {
	public void insertProduct(Product p);

	public List<Product> getItems();

	public Product ViewProductByID(int pid);

	public List<Product> getShoes();

	public List<Product> getTrend();

	public List<Product> getFruits();

	public List<Product> getBooks();

	public List<Product> getElectroncis();

	public List<Product> getGames();

	public List<Product> getHome();

	public List<Product> getToys();

	public List<Product> getWatches();

	public List<Product> getHealth();

}
