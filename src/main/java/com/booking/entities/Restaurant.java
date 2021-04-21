package com.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Va a hacer que la clase sea persistente en una Base de datos

@Entity
//El nombre que va a tener en la base de datos
@Table(name= "restaurants")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    // Debe tener una clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "address")
    private String address;


}
