package ru.mirea.task16;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
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

    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + text + '\'' +
                ", zipCode='" + zip + '\'' +
                '}';
    }
}
