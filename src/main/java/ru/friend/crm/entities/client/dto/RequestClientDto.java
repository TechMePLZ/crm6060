package ru.friend.crm.entities.client.dto;

import lombok.Getter;
import ru.friend.crm.entities.client.Messanger;

import java.time.OffsetDateTime;

@Getter
public class RequestClientDto {
    private String fullName;
    private String primaryPhone;
    private String secondaryPhone;
    private String email;
    private Messanger messenger;
    private String commentForClient;
    private OffsetDateTime createdAt;

}
