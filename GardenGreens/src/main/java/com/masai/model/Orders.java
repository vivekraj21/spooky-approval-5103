package com.masai.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(transactionMode, other.transactionMode);
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost, orderDate, quantity, transactionMode);
	}
	
	
	
	
}
