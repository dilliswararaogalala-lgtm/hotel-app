package com.step.hotel_app.service;

import com.step.hotel_app.models.HotelBooking;
import com.step.hotel_app.repository.BookingRepository;
import com.step.hotel_app.views.HotelBookingView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public HotelBookingView bookHotel(String userId, String hotelId, int rooms) {
        HotelBooking booking = bookingRepository.insert(new HotelBooking(userId, hotelId, rooms));
        return new HotelBookingView(booking.getId(), booking.getHotelId(), booking.getRooms());
    }

    public List<HotelBookingView> getBookings(String userId) {
        return bookingRepository.findHotelBookingsByUserId(userId).stream().map(booking -> new HotelBookingView(booking.getId(), booking.getHotelId(), booking.getRooms())).toList();
    }
}
