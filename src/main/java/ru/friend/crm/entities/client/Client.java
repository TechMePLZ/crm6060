package ru.friend.crm.entities.client;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import ru.friend.crm.entities.order.OrderCs;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private Messanger messenger;
    @Nullable
    private String commentForClient;

    private OffsetDateTime createdAt;

    @OneToMany( mappedBy = "client")
    private List<OrderCs> listOrders;


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
