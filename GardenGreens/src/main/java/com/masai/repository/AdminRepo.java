package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	@Query("from Admin a where a.adminId=?1")
	public List<Admin> findAdminById(Integer id);
	
	@Query("from Admin a where a.adminUsername=?1")
	public Optional<Admin> findByUsername(String username);
}
