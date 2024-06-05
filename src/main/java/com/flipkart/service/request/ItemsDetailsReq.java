package com.flipkart.service.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemsDetailsReq {
    String name;
    double price;
}

//token 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
