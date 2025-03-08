package com.layp.hotel.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{
    ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
