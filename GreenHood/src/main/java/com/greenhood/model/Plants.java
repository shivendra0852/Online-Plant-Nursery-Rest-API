package com.greenhood.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Plants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantId;
	private String plantName;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="PlanterId")
	private Planters planters;
}
