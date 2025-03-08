package com.layp.hotel.HotelService.service.implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.layp.hotel.HotelService.entity.Hotel;
import com.layp.hotel.HotelService.exception.ResourceNotFoundException;
import com.layp.hotel.HotelService.repository.Hotelepository;
import com.layp.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    Hotelepository hotelepository;
    @Override
    public Hotel saveHotel(Hotel Hotel) {
        String uuid= UUID.randomUUID().toString();
        Hotel.setId(uuid);
        return hotelepository.save(Hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Does Not Esixt"));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelepository.findAll();
    }

    @Override
    public Hotel updateHotel(String id, JsonNode HotelUpdates) {
        Hotel existingHotel = hotelepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        // Check and update fields based on the request body (JsonNode)
        if (HotelUpdates.has("name") && !HotelUpdates.get("name").isNull()) {
            existingHotel.setName(HotelUpdates.get("name").asText());
        }

        if (HotelUpdates.has("location") && !HotelUpdates.get("location").isNull()) {
            existingHotel.setLocation(HotelUpdates.get("location").asText());
        }
        if (HotelUpdates.has("starRating") && !HotelUpdates.get("starRating").isNull()) {
            existingHotel.setStarRating(HotelUpdates.get("starRating").asInt());
        }
        if (HotelUpdates.has("hasPool") && !HotelUpdates.get("hasPool").isNull()) {
            existingHotel.setHasPool(HotelUpdates.get("hasPool").asBoolean());
        }
        if (HotelUpdates.has("numberOfRooms") && !HotelUpdates.get("numberOfRooms").isNull()) {
            existingHotel.setNumberOfRooms(HotelUpdates.get("numberOfRooms").asInt());
        }
        if (HotelUpdates.has("pricePerNight") && !HotelUpdates.get("pricePerNight").isNull()) {
            existingHotel.setPricePerNight(HotelUpdates.get("pricePerNight").asDouble());
        }

        // Save the updated entity (this performs the update)
        return hotelepository.save(existingHotel);
    }

    @Override
    public void deleteHotel(String HotelId) {
        hotelepository.deleteById(HotelId);
    }
}
