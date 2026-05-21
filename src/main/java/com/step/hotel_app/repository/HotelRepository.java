package com.step.hotel_app.repository;

import com.step.hotel_app.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<Hotel> findHotelByCityName(String cityName);
}
