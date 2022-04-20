package com.vadimtanel.webhook.producer.service;

public interface KafkaService {
    void sendMessage(String message);
}
