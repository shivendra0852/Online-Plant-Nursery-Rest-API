package com.greenhood.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SEEDS")
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedId;
	
	@NotNull(message = "Name must not be Null")
	@NotBlank(message = "Name must not be Blank")
	@Size(min=1,max=15,message = "Seed name should be greater than 1 and less than 15")
	private String commonName;		
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Bloom Time must not be Blank")
	private String bloomTime;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Temperature must not be Blank")
	private String temperature;
	
	@NotNull(message = "Please Provide Required Input")
	@NotBlank(message = "Seed Description must not be Blank")
	private String seedDescription;
	
	@Enumerated(EnumType.STRING)
	private PlantType seedType;
	
	@NotNull(message = "Please Provide Required Input")
	@Min(value = 1,message = "Seed Stock must be greater than 1")
	private Integer seedStock;
	
	@NotNull(message = "Please Provide Required Input")
	@Min(value = 1,message = "Seed cost must be greater than 1")
	private Integer seedCost;
	
	@NotNull(message = "Please Provide Required Input")	
	@Min(value = 1,message = "Seed Quantity must be greater than 1")
	private Integer seedPerPacket;
	
	@JsonIgnore
	private Integer cartId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "seed")
	private Planter planter;
}
