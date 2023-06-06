package ru.friend.crm.repositories.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.order.OrderCs;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {




}
