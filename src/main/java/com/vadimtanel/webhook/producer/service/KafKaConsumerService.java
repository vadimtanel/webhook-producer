package com.vadimtanel.webhook.producer.service;

import org.springframework.kafka.annotation.KafkaListener;

public class KafKaConsumerService {
    final String TOPIC_NAME = "wenhook";
    final String GROUP_ID = "group_id";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consume(String message)
    {
        //String.format("Message recieved -> %s", message)
    }
}
