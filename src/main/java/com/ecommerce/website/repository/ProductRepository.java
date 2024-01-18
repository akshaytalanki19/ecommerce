package com.ecommerce.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.website.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
	@Query("select u from Product u")
	 public List<Product>  getAll();
	@Query("select u from Product u where u.pname in ('shoes', 'shoe')")
	public List<Product> getShoes();
}
