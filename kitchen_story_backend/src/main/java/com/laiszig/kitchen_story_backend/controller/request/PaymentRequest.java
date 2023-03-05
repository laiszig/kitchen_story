package com.laiszig.kitchen_story_backend.controller.request;

import lombok.Data;

@Data
public class PaymentRequest {

    private String type;

    private Integer cardNumber;

    private Integer cardCvv;
}
