package ru.friend.crm.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientId;
    @NotNull
    private String fullName;
    @NotNull
    private String primaryPhone;
    @NotNull
    private final String uid = UUID.randomUUID().toString();
    @Nullable
    private String secondaryPhone;
    @Nullable
    private String email;
    @Nullable
    private Messanger messenger;
    @Nullable
    private String commentForClient;

    private OffsetDateTime createdAt;


    public Client(String fullName, String primaryPhone, @Nullable String secondaryPhone,
                  @Nullable String email, @Nullable Messanger messenger, @Nullable String commentForClient,
                  OffsetDateTime createdAt) {
        this.fullName = fullName;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.email = email;
        this.messenger = messenger;
        this.commentForClient = commentForClient;
        this.createdAt = createdAt;
    }
}
