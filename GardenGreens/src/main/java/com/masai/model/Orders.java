package com.masai.model;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDate orderDate;
	private String transactionMode;
	private Integer quantity;
	private Double cost;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Set<Planter> planters = new HashSet<>();
	
	
	
	
}
