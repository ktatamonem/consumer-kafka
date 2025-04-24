package com.mk.events.app.consumer.listeners.eventhub;

import com.mk.events.utils.library.generic.consumer.manager.GenericKafkaConsumerManager;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHubListeners {

    private final KafkaListenerContainerFactory<?> eventHubContainerFactory;

    private final GenericKafkaConsumerManager genericKafkaConsumerManager;


    @PostConstruct
    public void startupListeners(){
        genericKafkaConsumerManager.registerListener("test-topic","$Default", message ->{
            System.out.println("[EventHub] test-topic message="+message);
        },eventHubContainerFactory);

        genericKafkaConsumerManager.registerListener("eventhub","$Default", message ->{
            System.out.println("[EventHub] eventhub message="+message);
        },eventHubContainerFactory);
    }

}
