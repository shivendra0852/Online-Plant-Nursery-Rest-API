package com.greenhood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenhood.model.PlantType;
import com.greenhood.model.Seed;

@Repository
public interface SeedDao extends JpaRepository<Seed, Integer>{
	
	//---------------------------Get Seed By Seed Type ------------------
	public List<Seed> findBySeedType(PlantType seedType);
}
