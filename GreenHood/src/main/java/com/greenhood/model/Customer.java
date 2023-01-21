package com.greenhood.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    
    @Size(min=3, max=15, message="length should be between 3 to 15 char")
    private String firstname;
    
    @Size(min=3, max=15, message="length should be between 3 to 15 char")
    private String lastName;
    
    
    @Email(message = "Please provide valid email")
    private String email;
    
    @Size(min = 8,max = 15,message = "length should be between 3 to 15 char")
    private String password;
    
    
    private String mobileNo;
    
   
	@Embedded
	private Address address;
	
}
