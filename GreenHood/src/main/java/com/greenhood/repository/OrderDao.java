package com.greenhood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greenhood.model.Order;
import com.greenhood.model.OrderDTO;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer>{
	
//	@Query("select new com.greenhood.model.OrderDTO(o.orderId,o.orderDate,o.totalCost) from Order o where o.customerId=?1")
//	public List<OrderDTO> viewOrders(Integer customerId);
}
