package com.flipkart.core.repository;

import com.flipkart.core.entities.ItemEntity;
import com.flipkart.core.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemEntity,Long> {



}

