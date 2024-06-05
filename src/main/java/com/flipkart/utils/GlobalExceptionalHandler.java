package com.flipkart.utils;

import com.flipkart.utils.exceptions.OrderNotCreatedException;
import com.flipkart.service.response.MessageApiResponse;
import com.flipkart.service.response.RestaurantMgmtAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotCreatedException.class)
    public ResponseEntity<RestaurantMgmtAPIResponse> handleOrderNotCreatedExceptiom(OrderNotCreatedException ex) {
        log.error("OrderNotCreatedException {}", ex);
         MessageApiResponse messageApiResponse = MessageApiResponse.builder().text(ex.getErrorCode().getInstantDisplayMessage()).code(ex.getErrorCode().getCode()).build();
        return new ResponseEntity<>(RestaurantMgmtAPIResponse.buildFailure(messageApiResponse), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestaurantMgmtAPIResponse> handleException(Exception ex) {
        log.error("Unhandled Exception", ex);
        MessageApiResponse messageApiResponse = MessageApiResponse.builder()
                .text("An unexpected error occurred.")
                .code("EOO")
                .build();
        return new ResponseEntity<>(RestaurantMgmtAPIResponse.buildFailure(messageApiResponse), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

