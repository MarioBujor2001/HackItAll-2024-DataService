package com.hackitall.dataservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "test", groupId = "consumer-group-1")
    public void consume(String message) {
        LOG.info("Consumer message {}", message);
    }
}
