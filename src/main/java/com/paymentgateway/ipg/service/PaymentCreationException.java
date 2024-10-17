package com.paymentgateway.ipg.service;

public class PaymentCreationException extends RuntimeException{
    public PaymentCreationException(String message) {
        super(message);
    
    }

    public PaymentCreationException(String string, Exception e) {
        super(string, e);
    }


}
