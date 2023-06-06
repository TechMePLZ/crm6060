package ru.friend.crm.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.client.Messanger;
import ru.friend.crm.entities.order.OrderCs;
import ru.friend.crm.exceptions.clientexceptions.ClientNotFoundExceptions;
import ru.friend.crm.repositories.client.ClientRepository;
import ru.friend.crm.repositories.orders.OrderCsRepository;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final OrderCsRepository orderCsRepository;



    @Autowired
    public ClientService(ClientRepository clientRepository, OrderCsRepository orderCsRepository) {
        this.clientRepository = clientRepository;
        this.orderCsRepository = orderCsRepository;
    }

//    /**
//     * Метод создание клиента. юид присваивается автматически
//     * @param fullName обязательное поле
//     * @param primaryPhone обязательное поле
//     * @param secondaryPhone необязательное поле
//     * @param email необязательное поле
//     * @param messenger необязательное поле
//     * @param commentForClient необязательное поле
//     * @return id созданного клинета
//     */


    public Client findClientById(Long id){
      return   clientRepository.findById(id).orElseThrow(() ->new ClientNotFoundExceptions("Клиент с id = " + id + " ненайден"));
    }

    public Client updateClientInfo( Long clientId ,String secondaryPhone, String email, Messanger messenger, String commentForClient){
        Client updateableClient = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundExceptions("Клиент с id = "
                + clientId + " ненайден"));
        updateClient(secondaryPhone, email, messenger, commentForClient, updateableClient);
        return updateableClient;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    public List<OrderCs> getAllOrdersForClient(Long clientId){
        return orderCsRepository.findAllByClient(clientRepository.findById(clientId).orElseThrow());
    }

    private void updateClient(String secondaryPhone, String email, Messanger messenger, String commentForClient, Client updateableClient) {
        updateableClient.setSecondaryPhone(secondaryPhone);
        updateableClient.setEmail(email);
        updateableClient.setMessenger(messenger);
        updateableClient.setCommentForClient(commentForClient);
    }



}
