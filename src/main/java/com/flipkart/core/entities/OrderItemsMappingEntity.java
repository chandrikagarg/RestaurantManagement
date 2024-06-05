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
@Table(name = "order_item_mapping")
public class OrderItemsMappingEntity {

    private static final long serialVersionUIZD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    Long orderId;

    @Column(name = "item_id")
    Long itemId;

    @Column(name = "qty")
    Double qty;

}
