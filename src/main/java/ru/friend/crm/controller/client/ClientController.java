package ru.friend.crm.controller.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.client.Messanger;
import ru.friend.crm.entities.client.dto.RequestClientDto;
import ru.friend.crm.entities.client.dto.ResponseClientDto;
import ru.friend.crm.entities.order.OrderCs;
import ru.friend.crm.service.client.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/v01/client")
public class ClientController {

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/")
    public ResponseEntity<Long> createClient(@RequestBody RequestClientDto requestClientDto) {
        log.debug("create client name {}", requestClientDto.getFullName());
        return ResponseEntity.ok(clientService.createClient(requestClientDto.getFullName(), requestClientDto.getPrimaryPhone(),
                requestClientDto.getSecondaryPhone(), requestClientDto.getSecondaryPhone(), requestClientDto.getMessenger(),
                requestClientDto.getCommentForClient()));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ResponseClientDto> getClintByID(@PathVariable Long clientId) {
        log.debug("getting client with id {} ", clientId);
        ResponseClientDto clientResponseDto = new ResponseClientDto(clientService.findClientById(clientId));
        return ResponseEntity.ok(clientResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseClientDto>> getAllClient() {
        log.debug("getting all clients");
        return ResponseEntity.ok(clientService.getAllClients().stream()
                .map(ResponseClientDto::new)
                .collect(Collectors.toList()));
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<ResponseClientDto> updateClient(@RequestBody ResponseClientDto requestClientDto, @PathVariable("clientId") Long clientId) {
        log.debug("client with id = {} was  updated sucsessfull", clientId);
        Client updatedClient = clientService.updateClientInfo(clientId, requestClientDto.getSecondaryPhone(), requestClientDto.getEmail(),
                Messanger.valueOf(requestClientDto.getMessenger()), requestClientDto.getCommentForClient());
        return ResponseEntity.ok(new ResponseClientDto(updatedClient));
    }

    /**
     * Так то надо мапить в дтошку, но не охота
     *
     * @param clientId
     * @return
     */
    @GetMapping("/{clientId}/orders")
    public List<OrderCs> getOrdersByClient(Long clientId) {
        return clientService.getAllOrdersForClient(clientId);
    }


}
