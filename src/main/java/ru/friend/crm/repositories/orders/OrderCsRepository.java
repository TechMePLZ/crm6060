package ru.friend.crm.repositories.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.order.OrderCs;

import java.util.List;
@Repository
public interface OrderCsRepository extends JpaRepository<OrderCs, Long> {


    List<OrderCs> findAllByClient(Client client);



}
