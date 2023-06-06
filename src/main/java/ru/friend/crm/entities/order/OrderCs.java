package ru.friend.crm.entities.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.friend.crm.entities.client.Client;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private Vendor vendor;

    private String model;

    private String bodyOfRepair;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    private boolean isReady;

    private OffsetDateTime createdAt;

    private OffsetDateTime closedAt;

   private boolean isNotified;

}
