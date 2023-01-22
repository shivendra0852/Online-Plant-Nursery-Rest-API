package com.greenhood.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="PLANTERS")
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="planterId")
	@Min(value=1, message = "Planter id must not be Negative or Zero")
	private Integer planterId;
	
	@Column(name="planterHeight")
	@Size(max=100,min=1,message="Planter hieght must be between 1 to 100")
	private float planterHeight;
	
	@Column(name="planterCapacity")
	@Size(max=10000, message = "Planter capacity should be below 10000")
	private int planterCapacity;
	
	@Min(value=1, message = "Drainage Holes must not Negative or zero")
	@Column(name="drainageHoles")
	private int drainageHoles;
	
	@Column(name="planterColor")
	@Size(max=25, min=2, message = "Planter color size must be between 2 to 25")
	@NotNull(message = "Planter color must not be null")
	private String planterColor;
	
	@Column(name="planterShape")
	@Size(max=25, min=2, message = "Planter shape size must be between 2 to 25")
	private String planterShape;
	
	@Column(name="planterStock")
	@Min(value=1, message = "Planter stock  must be above 1")
	private int planterStock;
	
	@Column(name="planterCost")
	@Min(value=50, message = "Planter cast price must be above 50")
	private int planterCost;
	
	//@Column(name="plantId")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name="Planter_plant", joinColumns = @JoinColumn(name="PlantId"),inverseJoinColumns = @JoinColumn(name="PlanterId"))
	private Plant plant;
	
	//@Column(name="seedId")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name="Planter_Seed", joinColumns = @JoinColumn(name="SeedId"),inverseJoinColumns = @JoinColumn(name="PlanterId"))
	@JoinColumn(name="SeedId")
	private Seed seed;
	
	@JsonIgnore
	private Integer cartId;
	
}
