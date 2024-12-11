package com.notification.service.functions;

import com.notification.service.dto.OrderDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class OrderNotificationFunctions {

    @Bean
    public Function<OrderDetail, String> orderEventReceiver() {
        return (orderDetail -> {
            sendEmailAndMessageToUser(orderDetail.getEmailId(), orderDetail.getPhoneNo());
            return orderDetail.getOrderId();
        });
    }

    private void sendEmailAndMessageToUser(String emailId, String phoneNo) {
        System.out.println("sending email to : " + emailId);
        System.out.println("sending message to : " + phoneNo);
        System.out.println("notification sent");
        System.out.println("---------------------------");
    }
}
