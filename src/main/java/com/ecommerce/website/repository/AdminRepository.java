package com.ecommerce.website.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.website.model.Admin;


 


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	@Query("select a from Admin a where email=?1 and password=?2")
	public Admin checkadminlogin(String auname,String apwd);
}
