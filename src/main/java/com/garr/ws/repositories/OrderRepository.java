package com.garr.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garr.ws.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
