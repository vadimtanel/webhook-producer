package com.vadimtanel.webhook.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientListenerEvent {
    @Id
    @GeneratedValue
    String guid;
    @JsonProperty("event_guid")
    String eventGuid;
    @JsonProperty("client_listener_guid")
    String clientListenerGuid;
}
