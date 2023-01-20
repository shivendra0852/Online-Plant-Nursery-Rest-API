package com.greenhood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    
    private LocalDate OrderDate;
    
    private String transactionMode;
    
    private Integer quantity;
    
    private Double totalCost;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    private Cart cart;

    private Integer cartId;

}