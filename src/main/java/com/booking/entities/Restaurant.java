package com.booking.entities;

import lombok.*;

import javax.persistence.*;

//Va a hacer que la clase sea persistente en una Base de datos

@Entity
//El nombre que va a tener en la base de datos
@Table(
        name = "restaurants",
        uniqueConstraints = {
                @UniqueConstraint(name = "restaurants_name_unique",
                        columnNames = "name")

        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    // Debe tener una clave primaria
    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    @Column(name = "name",
            nullable = false
    )

    private String name;
    @Column(name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(name = "image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String image;
    @Column(name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;


}
