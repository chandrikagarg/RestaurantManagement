package com.flipkart.core.repository;

import com.flipkart.core.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity,Long> {

    Optional<OrderEntity> findById(Long id);



}

