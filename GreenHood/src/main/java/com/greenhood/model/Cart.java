package com.greenhood.model;

import lombok.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Integer totalPrice;
    private Integer plantPrice;
    private Integer planterPrice;
    private Integer seedsPrice;
    private Integer plantQuantity;
    private Integer planterQuantity;
    private Integer seedsQuantity;
    private Integer totalItems;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Planter> planters = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Plant> plants = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Seeds> seeds = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Order order;

}
