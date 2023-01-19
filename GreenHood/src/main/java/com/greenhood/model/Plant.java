package com.greenhood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Data
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantId;
	@NotNull(message = "Name must not be Null")
	@NotBlank(message = "Name must not be Blank")
	@Size(min=5,max=15,message = "Plant name should be greater than 5 and less than 15")
	private String commonName;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "PlantHeight must not be Blank")
	@Size(max = 50,message = "Plant Height must not be greater than 50cm")
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
	@NotBlank(message = "Plant stock must not be Blank")
	private Integer plantsStock;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Plant Cost must not be Blank")
	private Double plantCost;
	
	
	
	
	
	public Plant() {
		// TODO Auto-generated constructor stub
	}	
	

}
