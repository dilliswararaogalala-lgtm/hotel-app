package com.step.hotel_app.controller;

import com.step.hotel_app.service.BookingService;
import com.step.hotel_app.views.BookingRequest;
import com.step.hotel_app.views.HotelBookedView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public HotelBookedView bookHotel(@RequestBody BookingRequest bookingRequest) {
        String userId = "12234";
        return bookingService.bookHotel(userId, bookingRequest.hotelId(), bookingRequest.rooms());
    }
}
