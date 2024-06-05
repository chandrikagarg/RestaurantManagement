package com.flipkart.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Restaurant {
    String name;
    String location;
    int maximumProcessingCapacity;
    int availableCapacity;
    List<Items> itemsList;


}
