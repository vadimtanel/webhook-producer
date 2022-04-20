package com.vadimtanel.webhook.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadimtanel.webhook.producer.model.*;
import com.vadimtanel.webhook.producer.repository.ClientListenerEventRepository;
import com.vadimtanel.webhook.producer.repository.ClientListenerRepository;
import com.vadimtanel.webhook.producer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private ClientListenerRepository clientListenerRepo;
    @Autowired
    private ClientListenerEventRepository clientListenerEventRepo;
    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private KafkaService kafkaService;

    @Override
    public boolean sendMessage(EventMessage eventMessage) {
        try {
            Event event = eventRepo.findByName(eventMessage.getEventName());
            List<ClientListenerEvent> clientDestinationsGuid = clientListenerEventRepo.findByEventGuid(event.getGuid());
            List<ClientDestination> clientDestinations = clientDestinationsGuid.stream()
                    .map(x -> clientListenerRepo.findByGuid(x.getClientListenerGuid()))
                    .collect(Collectors.toList());
            String guid = UUID.randomUUID().toString().replace("-", "").substring(0, 15);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            ExportEvent exportEvent = new ExportEvent(guid, formatter.format(new Date()), eventMessage, clientDestinations);
            ObjectMapper mapper = new ObjectMapper();

            try {
                String json = mapper.writeValueAsString(exportEvent);
                kafkaService.sendMessage(json);
            } catch (JsonProcessingException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}