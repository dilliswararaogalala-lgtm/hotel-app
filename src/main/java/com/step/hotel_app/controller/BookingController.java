package com.step.hotel_app.controller;

import com.step.hotel_app.models.Hotel;
import com.step.hotel_app.repository.HotelRepository;
import com.step.hotel_app.service.BookingService;
import com.step.hotel_app.views.BookingRequest;
import com.step.hotel_app.views.HotelBookingView;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public HotelBookingView bookHotel(@RequestBody BookingRequest bookingRequest) {
        String userId = "12234";
        return bookingService.bookHotel(userId, bookingRequest.hotelId(), bookingRequest.rooms());
    }

    @GetMapping
    public List<HotelBookingView> getBookings() {
        return bookingService.getBookings();
    }
}
