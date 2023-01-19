package com.greenhood.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
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
    @Size(min = 10,max = 12,message = "please Enter valid Mobile Number")
    private String mobile;
    
    @ElementCollection
	@Embedded
	private List<Address> address=new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

}
