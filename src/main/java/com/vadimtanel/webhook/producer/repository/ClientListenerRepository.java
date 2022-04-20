package com.vadimtanel.webhook.producer.repository;

import com.vadimtanel.webhook.producer.model.ClientDestination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientListenerRepository extends CrudRepository<ClientDestination, String> {
    ClientDestination findByGuid(String guid);

    List<ClientDestination> findAll();

    void removeByGuid(String guid);

    ClientDestination save(ClientDestination clientDestination);
}