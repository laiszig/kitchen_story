package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.controller.request.PurchaseRequest;
import com.laiszig.kitchen_story_backend.entity.Payment;
import com.laiszig.kitchen_story_backend.entity.Purchase;
import com.laiszig.kitchen_story_backend.entity.PurchaseItem;
import com.laiszig.kitchen_story_backend.repository.ProductRepository;
import com.laiszig.kitchen_story_backend.repository.PurchaseRepository;
import com.laiszig.kitchen_story_backend.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(
        origins = "http://localhost:4200"
)
public class PurchaseController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping("/purchase")
    public void purchase(@RequestBody PurchaseRequest purchaseRequest) {


        Purchase purchase = new Purchase();
        purchase.setUser(userRepository.findById(7L).get());

        Payment payment = new Payment();
        payment.setType("CREDIT");
        payment.setCardCvv(999);
        payment.setCardCvv(1);

        purchase.setPayment(payment);

        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setPrice(new BigDecimal("2.56"));
        purchaseItem.setProduct(productRepository.findById(1).get());
        purchaseItem.setQuantity(1);

        List<PurchaseItem> items = new ArrayList<>();
        items.add(purchaseItem);

        purchase.setPurchaseItems(items);


        purchaseRepository.save(purchase);


        System.out.println(purchaseRequest);
    }


}
