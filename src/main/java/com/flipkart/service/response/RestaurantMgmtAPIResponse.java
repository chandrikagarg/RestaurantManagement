package com.flipkart.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantMgmtAPIResponse {

    private Object data;

    private Boolean success;

    private MessageApiResponse message;


    public RestaurantMgmtAPIResponse(Object data, boolean success, MessageApiResponse message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public static RestaurantMgmtAPIResponse buildFailure(MessageApiResponse message) {
        if (message == null)
            throw new IllegalArgumentException("Invalid arguments");

        Map<String, String> data = new HashMap<>();
        data.put("message", message.getText());

        RestaurantMgmtAPIResponse orderMgmtAPIResponse = new RestaurantMgmtAPIResponse(data, false, message);

        log.info("OrderMgmtAPIResponse: " + orderMgmtAPIResponse);
        return orderMgmtAPIResponse;
    }

    public static RestaurantMgmtAPIResponse buildFailure(MessageApiResponse message, Object data) {
        if (message == null)
            throw new IllegalArgumentException("Invalid arguments");

        RestaurantMgmtAPIResponse orderMgmtAPIResponse = new RestaurantMgmtAPIResponse(data, false, message);

        log.info("OrderMgmtAPIResponse: " + orderMgmtAPIResponse);
        return orderMgmtAPIResponse;
    }

    public static RestaurantMgmtAPIResponse buildSuccess(Object data) {

        RestaurantMgmtAPIResponse orderMgmtAPIResponse = new RestaurantMgmtAPIResponse(data, true,null);
        log.info("RestaurantMgmtAPIResponse: " + orderMgmtAPIResponse);
        return orderMgmtAPIResponse;
    }
    public static RestaurantMgmtAPIResponse buildSuccess(MessageApiResponse message, Object data) {
        if (message == null)
            throw new IllegalArgumentException("Invalid arguments");

        RestaurantMgmtAPIResponse orderMgmtAPIResponse = new RestaurantMgmtAPIResponse(data, true, message);

        log.info("OrderMgmtAPIResponse: " + orderMgmtAPIResponse);
        return orderMgmtAPIResponse;
    }


}