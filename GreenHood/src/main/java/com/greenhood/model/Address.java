package com.greenhood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer addressId;
private Integer houseNo;
private String colony;
private String city;
private String state;
private Integer pincode;


}
