package com.merveozer.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MemberConsumer {
    private final Logger logger = LoggerFactory.getLogger(MemberConsumer.class);

    @KafkaListener(topics = "member-create", groupId = "group-id")
    public void consume(String message) {

        logger.info("Consumer: " + message);
    }
}
