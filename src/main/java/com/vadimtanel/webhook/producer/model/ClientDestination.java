package com.vadimtanel.webhook.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String guid;
    String name;
    String description;
    String url;
}
