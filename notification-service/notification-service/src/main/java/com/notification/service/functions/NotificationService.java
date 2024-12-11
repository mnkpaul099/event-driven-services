package com.notification.service.functions;

import com.notification.service.dto.OrderInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class NotificationService {

    @Bean
    public Supplier<String> testing() {
        return ()-> "testing";
    }

    @Bean
    public Function<OrderInformation, String> orderNotification(){
        return orderInformation -> {
            sendNotification(orderInformation);
            System.out.println(orderInformation.getOrderId());
            System.out.println(orderInformation.getOrderDate());
            System.out.println(orderInformation.getEmailId());

            return orderInformation.getOrderId();
        };
    }

    private void sendNotification(OrderInformation orderInformation) {
    }
}
