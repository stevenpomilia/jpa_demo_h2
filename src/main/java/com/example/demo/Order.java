package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// This represents customer table in Java. Refer to example before.
@Data
@Entity(name = "order")
@Table(name = "orders") // db: "customer"
public class Order {
    @Id // Specifies the Table ID
    @GeneratedValue // We can also use specified sequences but we wont get into this. For now we
                    // will just generate this automatically.
    @Column(nullable = false) // We can use this property to specify column attributes, such
                              // as, Nullable. This means the column cannot be empty
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    String shipped_location;

    @Column(nullable = false, columnDefinition = "TEXT")
    String purchase_total;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Order() {
        // This is the default constructor. It is necessary for SpringBoot.
    };

    public Order(Customer customer, String shipped_location, String purchase_total) {
        this.customer = customer;
        this.shipped_location = shipped_location;
        this.purchase_total = shipped_location;
    }
}
