package com.laiszig.kitchen_story_backend.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseRequest {

    private PaymentRequest payment;

    private List<ItemRequest> items;
}
