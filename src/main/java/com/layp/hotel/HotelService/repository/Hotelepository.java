package com.layp.hotel.HotelService.repository;

import com.layp.hotel.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hotelepository extends JpaRepository<Hotel,String> {
}
