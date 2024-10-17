package com.paymentgateway.ipg.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paymentgateway.ipg.service.PaymentCreationException;

public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentCreationException.class)
    public ResponseEntity<String> handlePaymentCreationException(PaymentCreationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                                  .getFieldErrors()
                                  .stream()
                                  .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                  .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(errorMessage);
    }
}