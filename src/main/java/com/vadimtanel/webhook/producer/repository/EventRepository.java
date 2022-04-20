package com.vadimtanel.webhook.producer.repository;

import com.vadimtanel.webhook.producer.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    Event findByName(String eventName);

    List<Event> findAll();

    void removeByGuid(String guid);

    Event save(Event event);
}