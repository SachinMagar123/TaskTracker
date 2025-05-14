package com.sachin.task.controllers;

import com.sachin.task.domain.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
//@ControllerAdvice tells Spring this class handles exceptions across all controllers
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class , IllegalMonitorStateException.class})
    //@ExceptionHandler specifies which exceptions this method handles
    public ResponseEntity<ErrorResponse> handleIllegalExceptions(RuntimeException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
