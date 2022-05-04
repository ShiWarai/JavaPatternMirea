package ru.mirea.task15;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "building")
@Setter
@Getter
@NoArgsConstructor
public class Building {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;

    @Override
    public String toString() {
        return "Building{" +
                "creationDate='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
