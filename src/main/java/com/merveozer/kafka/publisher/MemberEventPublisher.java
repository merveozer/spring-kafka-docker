package com.merveozer.kafka.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemberEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(MemberEventPublisher.class);
    public MemberEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void publishEvent(String kafkaTopic, String message) {
        kafkaTemplate.send(kafkaTopic, message);
        logger.info("Message was published...");
    }
}
