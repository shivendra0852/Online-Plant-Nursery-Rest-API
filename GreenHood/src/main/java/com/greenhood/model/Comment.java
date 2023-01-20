package com.greenhood.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime timeStamp;
	
	@Size(min=0, max=5, message = "Please provide rating 0 to 5")
	private String commentString;
	
	private Float rating;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Planter planter;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "planter")
	private List<Comment> comments = new ArrayList<>();

}
