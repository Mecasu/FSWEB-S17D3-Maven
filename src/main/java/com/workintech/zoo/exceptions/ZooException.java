package com.workintech.zoo.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;
@Getter
@Setter
public class ZooException extends RuntimeException{
    private HttpStatus status;

    public ZooException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
