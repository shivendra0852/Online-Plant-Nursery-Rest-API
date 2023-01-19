package com.greenhood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Plant {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantId;
	
	@NotNull(message = "Name must not be Null")
	@NotBlank(message = "Name must not be Blank")
	@Size(min=1,max=15,message = "Plant name should be greater than 5 and less than 15")
	private String commonName;
	
	@NotNull(message = "Please Provide Required Input")
	
	@Min(value = 1 , message = "plant height cannot be zero")
	private Integer plantHeight;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Bloom Time must not be Blank")
	private String bloomTime;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Plant Spread  must not be Blank")
	private String plantSpread;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Temperature must not be Blank")
	private String temperature;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Plant Description must not be Blank")
	private String plantDescription;
	
	@NotNull(message = "Please Provide Required Input")
	
	@Min(value = 0,message = "Plant cost must be greater than 0")
	private Integer plantsStock;
	
	@NotNull(message = "Please Provide Required Input")
	
	@Min(value = 1,message = "Plant cost must be greater than 1")
	private Double plantCost;
	
	
	
	
	
	public Plant() {
		// TODO Auto-generated constructor stub
	}
}
