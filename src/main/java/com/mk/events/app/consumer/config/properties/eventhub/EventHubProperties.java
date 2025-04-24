package com.mk.events.app.consumer.config.properties.eventhub;

import lombok.Data;

@Data
public class EventHubProperties {

    private String bootstrapServers;

    private String securityProtocol;

    private String saslMechanism;

    private String saslJaasConfig;
}
