package com.ecommerce.website.service;

import java.util.List;

import com.ecommerce.website.model.Product;

public interface ProductService {
	public void insertProduct(Product p);

	public List<Product> getItems();

	public Product ViewProductByID(int pid);

	public List<Product> getShoes();

}
