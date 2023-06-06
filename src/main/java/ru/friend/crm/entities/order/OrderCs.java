package ru.friend.crm.entities.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;
import ru.friend.crm.entities.client.Client;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderCs {

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

    @Nullable
    private OffsetDateTime closedAt;

    @Column(columnDefinition = "boolean default false")
    private boolean isNotified;

    public OrderCs(Vendor vendor, String model, String bodyOfRepair, Client client, OffsetDateTime createdAt) {
        this.vendor = vendor;
        this.model = model;
        this.bodyOfRepair = bodyOfRepair;
        this.client = client;
        this.createdAt = createdAt;
    }
}
