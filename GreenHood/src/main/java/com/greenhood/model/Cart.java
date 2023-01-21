package com.greenhood.model;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
