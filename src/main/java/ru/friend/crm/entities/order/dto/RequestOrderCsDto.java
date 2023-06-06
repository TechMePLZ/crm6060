package ru.friend.crm.entities.order.dto;

import lombok.Getter;
import ru.friend.crm.entities.order.Vendor;

@Getter
public class RequestOrderCsDto {
    private Vendor vendor;
    private String model;
    private String bodyOfRepair;



}
