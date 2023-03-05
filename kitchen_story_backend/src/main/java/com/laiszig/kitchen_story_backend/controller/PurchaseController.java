package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.controller.request.ItemRequest;
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

        Payment payment = new Payment();
        payment.setType(purchaseRequest.getPayment().getType());
        payment.setCardNumber(purchaseRequest.getPayment().getCardNumber());
        payment.setCardCvv(purchaseRequest.getPayment().getCardCvv());
        purchase.setPayment(payment);

        List<PurchaseItem> items = new ArrayList<>();
        for (ItemRequest item : purchaseRequest.getItems()) {
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setPrice(item.getPrice());
            purchaseItem.setProduct(productRepository.findById(item.getId()).get());
            purchaseItem.setQuantity(item.getQuantity());
            items.add(purchaseItem);
        }


        purchase.setPurchaseItems(items);

        purchase.setUser(userRepository.findById(7L).get());
        purchaseRepository.save(purchase);


        System.out.println(purchaseRequest);
    }


}
