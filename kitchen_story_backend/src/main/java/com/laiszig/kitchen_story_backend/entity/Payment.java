package com.laiszig.kitchen_story_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "payment_type")
    private String type;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "card_cvv")
    private Integer cardCvv;
}
