package ru.friend.crm.exceptions.orderexceptions;

public class OrderCsNotFoundException extends  RuntimeException{

    public OrderCsNotFoundException(String message) {
        super(message);
    }
}
