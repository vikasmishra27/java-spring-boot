package com.learning.restfulwebservices.exception;

import java.time.LocalDateTime;

public class exception {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
    public exception(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    
}
