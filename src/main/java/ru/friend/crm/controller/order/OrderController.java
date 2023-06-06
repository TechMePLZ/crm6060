package ru.friend.crm.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.friend.crm.entities.order.dto.RequestOrderCsDto;
import ru.friend.crm.service.order.OrderCsService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v01/orders")
public class OrderController {

    private final OrderCsService orderService;

    @Autowired
    public OrderController(OrderCsService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<Long> createOrder(@PathVariable("clientId") Long clientId, @RequestBody RequestOrderCsDto requestOrderCsDto){
        return ResponseEntity.ok(orderService.createOrder(clientId, requestOrderCsDto.getVendor(),requestOrderCsDto.getModel(),
                requestOrderCsDto.getBodyOfRepair()));
    }



}
