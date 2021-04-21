package com.booking.services.impl;

import com.booking.dtos.CreateRestaurantDTO;
import com.booking.dtos.RestaurantDTO;
import com.booking.entities.Restaurant;
import com.booking.exceptions.BookingException;
import com.booking.exceptions.InternalServerErrorException;
import com.booking.exceptions.NotFoundException;
import com.booking.repositories.RestaurantRepository;
import com.booking.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId),RestaurantDTO.class);
    }

    @Override
    public List<RestaurantDTO> getRestaurants() throws BookingException {
        List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(restaurant->modelMapper.map(restaurant,RestaurantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO createRestaurant(CreateRestaurantDTO createRestaurantDTO) throws BookingException {
        Restaurant restaurant= new Restaurant();
        restaurant.setName(createRestaurantDTO.getName());
        restaurant.setAddress(createRestaurantDTO.getAddress());
        restaurant.setDescription(createRestaurantDTO.getDescription());
        restaurant.setImage(createRestaurantDTO.getImage());
        try {
            restaurant = restaurantRepository.save(restaurant);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getRestaurantEntity(restaurant.getId()),RestaurantDTO.class);

    }

    private Restaurant getRestaurantEntity(Long restaurantId)throws BookingException{
        return restaurantRepository.findById(restaurantId)
                .orElseThrow( ()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));


    }
}
