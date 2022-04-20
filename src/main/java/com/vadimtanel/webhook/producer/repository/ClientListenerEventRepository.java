package com.vadimtanel.webhook.producer.repository;

import com.vadimtanel.webhook.producer.model.ClientListenerEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientListenerEventRepository extends CrudRepository<ClientListenerEvent, String> {

    List<ClientListenerEvent> findByEventGuid(String eventGuid);

    void removeByClientListenerGuid(String guid);

    void removeByEventGuid(String guid);

    ClientListenerEvent save(ClientListenerEvent clientListenerEvent);
}