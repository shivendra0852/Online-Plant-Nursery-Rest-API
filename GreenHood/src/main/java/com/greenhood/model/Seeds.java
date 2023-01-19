package com.greenhood.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Seeds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedId;
	private String seedName;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "seeds",fetch = FetchType.EAGER)
	private Planters palnters ;
}
