package com.order.service.controller;

import com.order.service.OrderDetail;
import com.order.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order-service")
public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    StreamBridge streamBridge;

    @PostMapping
    public ResponseEntity<?> createOrder() {
        OrderDetail orderDetail = orderService.createOrder();
        orderCreatedNotification(orderDetail);
        return ResponseEntity.ok("order created");
    }

    private void orderCreatedNotification(OrderDetail orderDetail) {
        boolean send = streamBridge.send("orderCreatedEvent-out-0", orderDetail);
        if(send) {
            System.out.println("event successfully sent to notification-service");
        } else {
            System.out.println("event sending failed");
        }
    }
}
