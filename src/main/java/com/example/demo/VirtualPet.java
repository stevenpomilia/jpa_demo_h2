package com.example.demo;

// import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// This represents customer table in Java. Refer to example before.
@Data
@Entity(name = "virtual_pet")
@Table(name = "virtual_pet") // db: "customer"
public class VirtualPet {
    @Id // Specifies the Table ID
    @GeneratedValue // We can also use specified sequences but we wont get into this. For now we
                    // will just generate this automatically.
    @Column(nullable = false) // We can use this property to specify column attributes, such
                              // as, Nullable. This means the column cannot be empty
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name; // alt: firstName -> db: first_name

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description; // alt: lastName -> db: last_name

    @Column(nullable = false, columnDefinition = "TEXT")
    private int hunger;

    @Column(nullable = false, columnDefinition = "TEXT")
    private int thirst;

    @Column(nullable = false, columnDefinition = "TEXT")
    private int boredom;

    public VirtualPet() {
        // This is the default constructor. It is necessary for SpringBoot.
    };

    public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
        this.name = name;
        this.description = description;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;

    }
}