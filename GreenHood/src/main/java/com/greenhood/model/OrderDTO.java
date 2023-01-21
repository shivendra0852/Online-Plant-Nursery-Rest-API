package com.greenhood.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Integer orderId;
//	private String firstName;
//	private String lastName;
	private LocalDateTime orderDate;
	private Integer totalCost;
	
}
