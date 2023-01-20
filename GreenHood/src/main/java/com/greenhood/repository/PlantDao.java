package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenhood.model.Plant;

public interface PlantDao extends JpaRepository<Plant, Integer>{

}
