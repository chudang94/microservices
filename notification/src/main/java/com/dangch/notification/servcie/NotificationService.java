package com.dangch.notification.servcie;


import com.dangch.orderservice.event.OrderPlaceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlaceEvent orderPlaceEvent){
        log.info("place order" + orderPlaceEvent);

        

    }
}
