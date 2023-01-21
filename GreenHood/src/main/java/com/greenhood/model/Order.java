package com.greenhood.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    
    private LocalDateTime orderDate;
    
    private Integer totalCost;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}