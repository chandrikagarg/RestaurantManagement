package com.flipkart.core.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Table(name = "item_details")
public class ItemEntity {

    private static final long serialVersionUIZD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "item_name")
    String itemName;

    @Column(name = "item_price")
    double itemPrice;

    @Column(name = "restaurant_id")
    Long restaurantId;


}
