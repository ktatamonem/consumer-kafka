package com.mk.events.app.consumer.listeners.kafka;

import com.mk.events.utils.library.generic.consumer.manager.GenericKafkaConsumerManager;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final KafkaListenerContainerFactory<?> kafkaContainerFactory;

    private final GenericKafkaConsumerManager genericKafkaConsumerManager;

    @PostConstruct
    public void startupListeners(){
        genericKafkaConsumerManager.registerListener("test-topic","console-consumer-45784", message ->{
            System.out.println("[KAFKA] message="+message);
        },kafkaContainerFactory);
    }

}
