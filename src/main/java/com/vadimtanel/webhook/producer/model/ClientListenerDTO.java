package com.vadimtanel.webhook.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientListenerDTO {
    String guid;
    String name;
    String description;
    String destination;
    List<Event> events;
}
