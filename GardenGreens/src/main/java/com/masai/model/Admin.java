
package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
