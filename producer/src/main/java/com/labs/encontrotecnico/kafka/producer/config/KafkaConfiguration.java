package com.labs.encontrotecnico.kafka.producer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
@Profile("cenario-com-admin")
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("labs.topic.2", 10, Short.valueOf("1"));
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic("labs.topic.3", 10, Short.valueOf("1"));
    }
}
