package com.greenhood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Integer totalPrice;
    private Integer totalItems;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Planter> plantersList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plant> plantsList  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seed> seedsList  = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Order> ordersList =new ArrayList<>();
    
    
//    public List<Plant> getPlantsList () {
//		return plants;
//	}
//
//	public void setPlants(List<Plant> plantsList ) {
//		this.plants = plants;
//	}

}
