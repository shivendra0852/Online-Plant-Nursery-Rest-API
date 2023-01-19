package com.greenhood.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value=1, message = "Planter id must not be Negative or Zero")
	private Integer planterId;
	
	@Size(max=100,min=1,message="Planter hieght must be between 1 to 100")
	private float planterHeight;
	
	@Size(max=10000, message = "Planter capacity should be below 10000")
	private int planterCapacity;
	
	@Min(value=1, message = "Drainage Holes must not Negative or zero")
	private int drainageHoles;
	
	@Size(max=25, min=2, message = "Planter color size must be between 2 to 25")
	@NotNull(message = "Planter color must not be null")
	private String planterColor;
	
	@Size(max=25, min=2, message = "Planter shape size must be between 2 to 25")
	private String planterShape;
	
	@Min(value=1, message = "Planter stock  must be above 1")
	private int planterStock;
	
	@Min(value=50, message = "Planter cast price must be above 50")
	private int planterCost;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name="Planter_plant", joinColumns = @JoinColumn(name="PlantId"),inverseJoinColumns = @JoinColumn(name="PlanterId"))
	private Plant plant;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name="Planter_Seed", joinColumns = @JoinColumn(name="SeedId"),inverseJoinColumns = @JoinColumn(name="PlanterId"))
	@JoinColumn(name="SeedId")
	private Seed seed;
	
	
}
