package com.greenhood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Seed {

	@OneToOne
	private Planter planter;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedId;
}
