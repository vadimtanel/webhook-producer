package com.vadimtanel.webhook.producer.controller;

import com.vadimtanel.webhook.producer.model.EventMessage;
import com.vadimtanel.webhook.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MessageController.BASE_URL)
@CrossOrigin
public class MessageController {
    static final String BASE_URL = "api/message";

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/send",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity send(@RequestBody EventMessage eventMessage) {
        boolean isSuccess = messageService.sendMessage(eventMessage);
        HttpStatus status = isSuccess ? HttpStatus.OK : HttpStatus.BAD_GATEWAY;
        ResponseEntity responseEntity = new ResponseEntity(status);
        return responseEntity;
    }
}
