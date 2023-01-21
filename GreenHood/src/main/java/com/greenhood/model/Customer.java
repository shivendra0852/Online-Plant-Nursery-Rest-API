package com.greenhood.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @Column(unique = true)
    @Email(message = "Please provide valid email")
    private String email;
    
    @Size(min = 8,max = 15,message = "length should be between 3 to 15 char")
    private String password;
    
    @Column(unique = true)
    private String mobileNo;
    
   
	@Embedded
	private Address address;
	
}
