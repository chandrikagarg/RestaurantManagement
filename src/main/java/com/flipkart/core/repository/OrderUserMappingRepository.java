package com.flipkart.core.repository;

import com.flipkart.core.entities.OrderEntity;
import com.flipkart.core.entities.OrderUserMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderUserMappingRepository extends JpaRepository<OrderUserMappingEntity,Long> {

    List<OrderUserMappingEntity> findByUserId(Long userID);



}

