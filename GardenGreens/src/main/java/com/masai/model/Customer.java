package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String username;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Set<Orders> orders = new HashSet<>();	
}
