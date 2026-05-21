package com.step.hotel_app.repository;

import com.step.hotel_app.models.HotelBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<HotelBooking, String> {
}
