package com.layp.hotel.HotelService.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.hotel.HotelService.entity.Hotel;
import com.layp.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Endpoint to save a new hotel
    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    // Endpoint to get a hotel by ID
    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    // Endpoint to get all hotels
    @GetMapping("/allHotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotel();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    // Endpoint to update a hotel
    @PutMapping("/updateHotel/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable String id,
            @RequestBody JsonNode hotelUpdates
    ) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelUpdates);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    // Endpoint to delete a hotel by ID
    @DeleteMapping("/removeHotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

