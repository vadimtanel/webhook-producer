package com.vadimtanel.webhook.producer.service;

import com.vadimtanel.webhook.producer.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    boolean sendMessage (EventMessage eventMessage);
}
