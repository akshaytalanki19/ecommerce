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
	@Query("select u from Product u where u.pname in ('health', 'Health')")
	public List<Product> getHealth();
	@Query("select u from Product u where u.pname in ('watch', 'Watch' , 'clock')")
	public List<Product> getWatches();
	@Query("select u from Product u where u.pname in ('toys', 'toy' , 'Toy')")
	public List<Product> getToys();
	@Query("select u from Product u where u.pname in ('home', 'Home' , 'Homemade')")
	public List<Product> getHome();
	@Query("select u from Product u where u.pname in ('Games', 'games' , 'sports')")
	public List<Product> getGames();
	@Query("select u from Product u where u.pname in ('electronics', 'Electronics')")
	public List<Product> getElectroncis();
	@Query("select u from Product u where u.pname in ('Books', 'books')")
	public List<Product> getBooks();
	@Query("select u from Product u where u.pname in ('fruits', 'fruit')")
	public List<Product> getFruits();
	@Query("select u from Product u ORDER BY u.id DESC")
	public List<Product> getTrend();
}
