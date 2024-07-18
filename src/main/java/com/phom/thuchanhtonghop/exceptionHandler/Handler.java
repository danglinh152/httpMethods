package com.phom.thuchanhtonghop.exceptionHandler;


import com.phom.thuchanhtonghop.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(er);
    }

}
