package ru.friend.crm.entities.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.friend.crm.entities.client.Client;

import java.time.OffsetDateTime;


@NoArgsConstructor
@Getter
public class ResponseClientDto {
    private String fullName;
    private String primaryPhone;
    private String secondaryPhone;
    private String email;
    private String messenger;
    private String commentForClient;
    private OffsetDateTime createdAt;


    public ResponseClientDto(Client client) {
        this.fullName = client.getFullName();
        this.primaryPhone = client.getPrimaryPhone();
        this.secondaryPhone = client.getSecondaryPhone();
        this.email = client.getEmail();
        if (client.getMessenger() != null) this.messenger = client.getMessenger().toString();
        this.commentForClient = client.getCommentForClient();
        this.createdAt = client.getCreatedAt();
    }
}
