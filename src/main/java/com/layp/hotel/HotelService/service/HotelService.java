package com.layp.hotel.HotelService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    // save Hotel
    public Hotel saveHotel(Hotel Hotel);
    // get Hotel from id
    public Hotel getHotelById(String id);
    // get all Hotel
    public List<Hotel> getAllHotel();
    // TODO: update Hotel
    public Hotel updateHotel(String id, JsonNode Hotel);
    // TODO: delete Hotel
    public void deleteHotel(String HotelId);
}
