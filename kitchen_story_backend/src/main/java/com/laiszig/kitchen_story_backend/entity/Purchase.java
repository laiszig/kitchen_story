package com.laiszig.kitchen_story_backend.entity;

import com.laiszig.kitchen_story_backend.security.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "purchase_id", nullable = true)
    private Payment payment;

   // @OneToMany(mappedBy = "purchaseItems", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinColumn(name = "purchase_id")
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> purchaseItems;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    private UserEntity user;
}
