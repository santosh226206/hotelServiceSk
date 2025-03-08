package com.layp.hotel.HotelService.domain;

import org.springframework.http.HttpStatus;


public class HotelResponse {
    private String message;  // Corrected field name
    private boolean success;
    private HttpStatus status;

    public HotelResponse(boolean success, HttpStatus status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public HotelResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
