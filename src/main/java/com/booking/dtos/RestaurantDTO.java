package com.booking.dtos;

import lombok.Getter;
import lombok.Setter;
// Mostrar los datos que se van a mostrar
// Ver restaurantes disponibles
@Getter
@Setter
public class RestaurantDTO {

    private Long id;
    private String name;
    private String address;
    private String description;
    private String image;
}
