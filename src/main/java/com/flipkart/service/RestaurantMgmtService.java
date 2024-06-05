package com.flipkart.service;


import com.flipkart.core.entities.*;
import com.flipkart.core.enums.OrderStatusEnum;
import com.flipkart.core.repository.*;
import com.flipkart.service.request.AddRestaurantReq;
import com.flipkart.service.request.ItemsDetailsReq;
import com.flipkart.service.request.OrderItemReq;
import com.flipkart.service.request.PlaceOrderReq;
import com.flipkart.service.response.RestaurantMgmtAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RestaurantMgmtService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderUserMappingRepository orderUserMappingRepository;

    @Autowired
    OrderItemMappingRepository orderItemMappingRepository;

    public RestaurantMgmtAPIResponse findAllRestaurants() {
        List<RestaurantEntity> restaurantEntityList =  restaurantRepository.findAll();

        return  RestaurantMgmtAPIResponse.buildSuccess(restaurantEntityList);

    }


    public RestaurantMgmtAPIResponse add(AddRestaurantReq addRestaurantReq) {

        List<ItemEntity> itemEntities = new ArrayList<>();
        RestaurantEntity restaurantEntity = RestaurantEntity.builder()
                .restaurantName(addRestaurantReq.getName())
                .availableCapacity(addRestaurantReq.getMaxCapacity())
                .location(addRestaurantReq.getLocation())
                .maximumProcessingCapacity(addRestaurantReq.getMaxCapacity())
                .build();
        restaurantEntity = restaurantRepository.save(restaurantEntity);

        for(ItemsDetailsReq itemsDetailsReq: addRestaurantReq.getItemsList()){
            itemEntities.add(ItemEntity.builder()
                            .restaurantId(restaurantEntity.getId())
                            .itemName(itemsDetailsReq.getName())
                            .itemPrice(itemsDetailsReq.getPrice())
                    .build());
        }
        itemsRepository.saveAll(itemEntities);
        return RestaurantMgmtAPIResponse.buildSuccess("added successfully");
    }

    public RestaurantMgmtAPIResponse placeOrder(PlaceOrderReq placeOrderReq) {
        OrderEntity orderEntity = OrderEntity.builder()
                .restaurantId(placeOrderReq.getResId())
                .orderStatus(OrderStatusEnum.INITIATED)
                .build();

         orderEntity =  ordersRepository.save(orderEntity);

         OrderUserMappingEntity orderUserMappingEntity = OrderUserMappingEntity.builder()
                 .userId(placeOrderReq.getUserId())
                 .orderId(orderEntity.getId())
                 .build();
         orderUserMappingEntity = orderUserMappingRepository.save(orderUserMappingEntity);

         List<OrderItemsMappingEntity> orderItemsMappingEntities = new ArrayList<>();

         for(OrderItemReq orderItemReq: placeOrderReq.getOrderItemReq())
         {
             orderItemsMappingEntities.add(OrderItemsMappingEntity.builder()
                             .orderId(orderEntity.getId())
                             .qty(orderItemReq.getQty())
                             .itemId(orderItemReq.getId())
                     .build());
         }
         orderItemMappingRepository.saveAll(orderItemsMappingEntities);



        return RestaurantMgmtAPIResponse.buildSuccess("placed prder");
    }
}
