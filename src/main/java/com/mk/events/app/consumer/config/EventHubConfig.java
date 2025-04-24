package com.mk.events.app.consumer.config;

import com.mk.events.app.consumer.config.properties.ConsumerProperties;
import com.mk.events.utils.library.generic.producer.GenericKafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(ConsumerProperties.class)
public class EventHubConfig {


    @Bean("eventHubConsumerFactory")
    public ConsumerFactory<String, String> eventHubConsumerFactory(ConsumerProperties properties) {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getEventHubProps().getBootstrapServers());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put("security.protocol", properties.getEventHubProps().getSecurityProtocol());
        config.put("sasl.mechanism", properties.getEventHubProps().getSaslMechanism());
        config.put("sasl.jaas.config", properties.getEventHubProps().getSaslJaasConfig());
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean("eventHubContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> eventHubContainerFactory(
            @Qualifier("eventHubConsumerFactory") ConsumerFactory<String, String> factory) {
        ConcurrentKafkaListenerContainerFactory<String, String> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(factory);
        return containerFactory;
    }

}
