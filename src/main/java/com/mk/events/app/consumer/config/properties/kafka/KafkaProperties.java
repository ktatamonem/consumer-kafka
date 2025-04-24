package com.mk.events.app.consumer.config.properties.kafka;

import lombok.Data;

@Data
public class KafkaProperties {

    private String bootstrapServers;

    private String securityProtocol;

    private String saslMechanism;

    private String saslJaasConfig;
}
