package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenhood.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{

}
