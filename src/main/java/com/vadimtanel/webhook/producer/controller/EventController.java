package com.vadimtanel.webhook.producer.controller;

import com.vadimtanel.webhook.producer.model.EventMessage;
import com.vadimtanel.webhook.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EventController.BASE_URL)
@CrossOrigin
public class EventController {

    @Autowired
    MessageService messageService;

    static final String BASE_URL = "api/event";

    @RequestMapping(value = "/send",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity send(@RequestBody EventMessage eventMessage) {
        boolean isError = messageService.sendMessage(eventMessage);
        HttpStatus status = isError ? HttpStatus.BAD_GATEWAY : HttpStatus.OK;
        ResponseEntity responseEntity = new ResponseEntity(status);
        return responseEntity;
    }
}
