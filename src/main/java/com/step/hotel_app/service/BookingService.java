package com.step.hotel_app.service;

import com.step.hotel_app.models.HotelBooking;
import com.step.hotel_app.repository.BookingRepository;
import com.step.hotel_app.views.HotelBookedView;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public HotelBookedView bookHotel(String userId, String hotelId, int rooms) {
        HotelBooking booking = bookingRepository.insert(new HotelBooking(userId, hotelId, rooms));
        return new HotelBookedView(booking.getId());
    }
}
