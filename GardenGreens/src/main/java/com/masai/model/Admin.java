package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

	@Id
	private Integer adminId;
	@NotNull
	private String adminUsername;
	@NotNull
	private String adminPassword;
	
	
	
	
}
