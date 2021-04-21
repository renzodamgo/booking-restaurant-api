package com.booking.controllers;

import com.booking.dtos.CreateRestaurantDTO;
import com.booking.dtos.RestaurantDTO;
import com.booking.exceptions.BookingException;
import com.booking.responses.BookingResponse;
import com.booking.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "booking-restaurant"+ "/V1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurants/{restaurantId}")
    public BookingResponse<RestaurantDTO> getRestaurantById(@PathVariable Long restaurantId) throws BookingException{

        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), " OK",
                restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurants")
    public BookingResponse<List<RestaurantDTO>> getRestaurants() throws BookingException{

        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), " OK",
                restaurantService.getRestaurants());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/restaurants")
    public BookingResponse<RestaurantDTO> createRestaurant(@RequestBody CreateRestaurantDTO createRestaurantDTO) throws BookingException{

        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), " OK",
                restaurantService.createRestaurant(createRestaurantDTO));

    }
}
