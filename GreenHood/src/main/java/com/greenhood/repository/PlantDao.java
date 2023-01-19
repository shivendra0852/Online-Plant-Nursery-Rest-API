package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenhood.model.Plant;

@Repository
public interface PlantDao extends JpaRepository<Plant, Integer>{

}
