package com.booking.repositories;

import com.booking.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Extiende el repository JPA para executar Queries en la base de Datos y la tabla Restaurant con ID de tipo Long
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    // Buscar Restaurant por Id

    Optional<Restaurant> findById(Long id);

    Optional<Restaurant> findByName(String nameRestaurant);

    @Query("SELECT Rest FROM Restaurant Rest")
    List<Restaurant> findRestaurants();
}
