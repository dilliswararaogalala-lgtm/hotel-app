package com.step.hotel_app.controller;

import com.step.hotel_app.models.HotelBooking;
import com.step.hotel_app.repository.BookingRepository;
import com.step.hotel_app.views.HotelBookedView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.AutoConfigureDataMongo;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureDataMongo
@AutoConfigureRestTestClient
class BookingControllerTest {

    @Autowired
    RestTestClient client;

    @Autowired
    BookingRepository repository;

    @Test
    void shouldBookAHotel() {
        HotelBooking hotelBooking = new HotelBooking("12234", "1", 1);
        HotelBookedView responseBody = client.post().uri("/api/bookings").body(hotelBooking).exchange().expectStatus().isOk().expectBody(HotelBookedView.class).returnResult().getResponseBody();

        assertNotNull(repository.findById(responseBody.bookingId()));
    }
}