package com.layp.hotel.HotelService.exception;

//import com.layp.userService.domain.UserResponse;
import com.layp.hotel.HotelService.domain.HotelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalResponseHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HotelResponse> handlerResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        String message = resourceNotFoundException.getMessage();

        // Create a HotelResponse using getters and setters
        HotelResponse hotelResponse = new HotelResponse();
//        userResponse.setMessage(message);  // Setting the message
//        userResponse.setSuccess(true);     // Setting the success field to true
//        userResponse.setStatus(HttpStatus.NOT_FOUND);  // Setting the status field to NOT_FOUND
        hotelResponse.setMessage(message);
        hotelResponse.setSuccess(true);
        hotelResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(hotelResponse, HttpStatus.NOT_FOUND);
    }
}
