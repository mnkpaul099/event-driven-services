package com.order.service.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotifyService {

    @Bean
    public Consumer<String> consumeAck(){
        return (orderId) -> {
            System.out.println("Ack sent for orderId     : " + orderId);
        };
    }
}
