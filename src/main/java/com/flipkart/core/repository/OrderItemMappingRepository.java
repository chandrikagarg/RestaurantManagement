package com.flipkart.core.repository;

import com.flipkart.core.entities.OrderItemsMappingEntity;
import com.flipkart.core.entities.OrderUserMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMappingRepository extends JpaRepository<OrderItemsMappingEntity,Long> {

    List<OrderItemsMappingEntity> findByOrderId(Long orderId);



}

