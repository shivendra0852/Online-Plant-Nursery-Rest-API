package com.greenhood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

private Integer houseNo;
private String colony;
private String city;
private String state;
private Integer pincode;


}
