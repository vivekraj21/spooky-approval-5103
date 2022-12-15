package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	@Query("from Customer c where c.username=?1")
	public Optional<Customer> findByUsername(String username);
}
