package com.booking.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateRestaurantDTO {
    private String name;
    private String address;
    private String description;
    private String image;
}
