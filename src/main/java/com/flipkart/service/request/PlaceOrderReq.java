package com.flipkart.service.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlaceOrderReq {
    Long resId;
    List<OrderItemReq> orderItemReq;
    Long userId;

}
