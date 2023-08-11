package com.example.demo;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// This represents customer table in Java. Refer to example before.
@Data
@Table(name = "Customer") // db: "customer"
@Entity(name = "Customer")
public class Customer {
    @Id // Specifies the Table ID
    @GeneratedValue // We can also use specified sequences but we wont get into this. For now we
                    // will just generate this automatically.
    @Column(nullable = false) // We can use this property to specify column attributes, such
                              // as, Nullable. This means the column cannot be empty
    private long id; 
    @Column(nullable = false, columnDefinition = "TEXT")
    private String first_name; // alt: firstName -> db: first_name
    @Column(nullable = false, columnDefinition = "TEXT")
    private String last_name; // alt: lastName -> db: last_name
    @Column(nullable = false, columnDefinition = "TEXT")
    private String date_joined;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String phone_number;

    public Customer() {
        // This is the default constructor. It is necessary for SpringBoot.
    };

    public Customer(String first_name, String last_name, String date_joined, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_joined = date_joined;
        this.phone_number = phone_number;
    }
}
