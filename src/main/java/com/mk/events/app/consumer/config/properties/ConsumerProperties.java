package com.mk.events.app.consumer.config.properties;


import com.mk.events.app.consumer.config.properties.eventhub.EventHubProperties;
import com.mk.events.app.consumer.config.properties.kafka.KafkaProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties(prefix = "consumer")
public class ConsumerProperties {

    @NestedConfigurationProperty
    EventHubProperties eventHubProps;

    @NestedConfigurationProperty
    KafkaProperties kafkaProps;


}
