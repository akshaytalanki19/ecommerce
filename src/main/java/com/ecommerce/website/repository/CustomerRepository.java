package com.ecommerce.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.website.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<User, Integer>
{
	@Query("select u from User u where email=?1 and password=?2")
	public User checkuserlogin(String name, String pwd);
    
    
}
