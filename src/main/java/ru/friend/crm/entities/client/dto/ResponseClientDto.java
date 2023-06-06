package ru.friend.crm.entities.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.friend.crm.entities.client.Client;
import ru.friend.crm.entities.client.Messanger;

import java.time.OffsetDateTime;


@NoArgsConstructor
@Getter
public class ClientResponseDto {
    private String fullName;
    private String primaryPhone;
    private String secondaryPhone;
    private String email;
    private String messenger;
    private String commentForClient;
    private OffsetDateTime createdAt;

//    public ClientResponseDto(Client client) {
//        fullName = client.getFullName();
//        primaryPhone = client.getPrimaryPhone();
//        createdAt = client.getCreatedAt();
//        email = client.getEmail();
//        secondaryPhone = client.getSecondaryPhone();
//        messenger =client.getMessenger().toString();
//        commentForClient = client.getCommentForClient();
//    }

    public ClientResponseDto(Client client) {
        this.fullName = client.getFullName();
        this.primaryPhone = client.getPrimaryPhone();
        this.secondaryPhone = client.getSecondaryPhone();
        this.email = client.getEmail();
        assert client.getMessenger() != null;
        this.messenger = client.getMessenger().toString();
        this.commentForClient = client.getCommentForClient();
        this.createdAt = client.getCreatedAt();
    }
}
