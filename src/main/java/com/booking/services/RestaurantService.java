package com.booking.services;

import com.booking.dtos.CreateRestaurantDTO;
import com.booking.dtos.RestaurantDTO;
import com.booking.exceptions.BookingException;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO getRestaurantById(Long restaurantId) throws BookingException;
    List<RestaurantDTO> getRestaurants() throws BookingException;
    RestaurantDTO createRestaurant(CreateRestaurantDTO createRestaurantDTO) throws BookingException;
}
