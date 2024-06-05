package com.flipkart.core.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "restaurant_details")
public class RestaurantEntity {
//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
    private static final long serialVersionUIZD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "restaurant_name")
    String restaurantName;

    @Column(name = "location")
    String location;

    @Column(name = "maximum_capacity")
    int maximumProcessingCapacity;

    @Column(name = "available_capacity")
    int availableCapacity;


}
