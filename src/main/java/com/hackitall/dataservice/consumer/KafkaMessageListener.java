package com.hackitall.dataservice.consumer;

import com.hackitall.dataservice.cache.EventsCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "energyEvents", groupId = "consumer-group-1")
    public void consumer0(String message) {
        process("Consumer0", message);
    }
    @KafkaListener(topics = "energyEvents", groupId = "consumer-group-1")
    public void consumer1(String message) {
        process("Consumer1", message);
    }
    @KafkaListener(topics = "energyEvents", groupId = "consumer-group-1")
    public void consumer2(String message) {
        process("Consumer2", message);
    }
    @KafkaListener(topics = "energyEvents", groupId = "consumer-group-1")
    public void consumer3(String message) {
        process("Consumer3", message);
    }

    private void process(String consumerName, String message){
        LOG.info("{} processed message {}", consumerName, message);
        EventsCache.add(message);
    }
}
