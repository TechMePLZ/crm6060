package ru.friend.crm.service.order;

import org.springframework.stereotype.Service;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.order.OrderCs;
import ru.friend.crm.entities.order.Vendor;
import ru.friend.crm.exceptions.clientexceptions.ClientNotFoundExceptions;
import ru.friend.crm.exceptions.orderexceptions.OrderCsNotFoundException;
import ru.friend.crm.repositories.client.ClientRepository;
import ru.friend.crm.repositories.orders.OrderCsRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderCsService {

    private final OrderCsRepository orderCsRepository;
    private final ClientRepository clientRepository;

    public OrderCsService(OrderCsRepository orderCsRepository, ClientRepository clientRepository) {
        this.orderCsRepository = orderCsRepository;
        this.clientRepository = clientRepository;
    }

    public Long createOrder(Long clientId, Vendor vendor, String model ,String bodyOfRepair){
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundExceptions("Клиент с id =  " + clientId + " не найден"));
        return orderCsRepository.save(new OrderCs(vendor, model, bodyOfRepair, client , OffsetDateTime.now())).getOrderId();
    }


    public OrderCs getOrder(Long orderId){
        return orderCsRepository.findById(orderId).orElseThrow(() -> new OrderCsNotFoundException("Заказ с id = " + orderId + " не найден"));
    }

//    /**
//     * метод для поиска последних 10 созданых заказов
//     * @return
//     */
//    public List<OrderCs> getListOrdersTop10ByCreatedAt(){
//        return orderCsRepository.findTop10ByCreatedAtDesc();
//    }

    /**
     * Установка флага на готовность заказа. заказ пришел на склад
     * @param orderId
     * @return
     */
    public OrderCs setOrderCsIsReady(Long orderId){
        OrderCs updatedOrder = orderCsRepository.findById(orderId).orElseThrow(() -> new OrderCsNotFoundException("Заказ с id = " + orderId + " не найден"));
        updatedOrder.setReady(true);
       return updatedOrder;
    }

    /**
     * Закрытие закза. После того как его забрали
     * @param orderId
     * @return
     */
    public  OrderCs setOrderCsClosedAt(Long orderId){
        OrderCs updatedOrder = orderCsRepository.findById(orderId).orElseThrow(() -> new OrderCsNotFoundException("Заказ с id = " + orderId + " не найден"));
        updatedOrder.setClosedAt(OffsetDateTime.now());
        return updatedOrder;
    }






}
