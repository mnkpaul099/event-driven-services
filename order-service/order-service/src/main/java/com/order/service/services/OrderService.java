package com.order.service.services;

import com.order.service.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public OrderDetail createOrder() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(UUID.randomUUID().toString());
        orderDetail.setUserId("user101");
        orderDetail.setEmailId("user1@abc.com");
        orderDetail.setPhoneNo("54231689");
        orderDetail.setCourseId("JAVA101");

        return orderDetail;
    }
}
