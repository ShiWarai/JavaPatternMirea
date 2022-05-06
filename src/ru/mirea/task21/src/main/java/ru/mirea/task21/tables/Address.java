package ru.mirea.task21.tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address_relationship")
@Setter
@Getter
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;
    @Column(name = "zip")
    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private List<Building> buildings = new ArrayList<>();

    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + text + '\'' +
                ", zipCode='" + zip + '\'' +
                '}';
    }
}
