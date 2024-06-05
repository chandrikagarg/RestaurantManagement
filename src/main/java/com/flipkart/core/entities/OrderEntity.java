package com.flipkart.core.entities;

import com.flipkart.core.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Table(name = "order_details")
public class OrderEntity {

    private static final long serialVersionUIZD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "restaurant_id")
    Long restaurantId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    OrderStatusEnum orderStatus;



}
