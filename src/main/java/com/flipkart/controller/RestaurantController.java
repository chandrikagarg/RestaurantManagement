package com.flipkart.controller;

import com.flipkart.service.RestaurantMgmtService;
import com.flipkart.service.request.AddRestaurantReq;
import com.flipkart.service.request.PlaceOrderReq;
import com.flipkart.service.response.RestaurantMgmtAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantMgmtService restaurantMgmtService;

    @GetMapping("/find-all")
    public RestaurantMgmtAPIResponse findAllRestaurants(){
        return restaurantMgmtService.findAllRestaurants();
    }

   @PostMapping("add-restaurant")
    public RestaurantMgmtAPIResponse addRestaurant(@RequestBody AddRestaurantReq addRestaurantReq){
        return restaurantMgmtService.add(addRestaurantReq);
   }

    @PostMapping("place-order")
    public RestaurantMgmtAPIResponse addRestaurant(@RequestBody PlaceOrderReq placeOrderReq){
        return restaurantMgmtService.placeOrder(placeOrderReq);
    }
}