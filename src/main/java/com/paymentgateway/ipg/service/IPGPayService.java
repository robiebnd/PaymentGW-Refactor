package com.paymentgateway.ipg.service;
import com.paymentgateway.ipg.dto.PaymentCreateRequest;
import com.paymentgateway.ipg.dto.PaymentResponseDTO;


public interface IPGPayService {
    PaymentResponseDTO createPayment(PaymentCreateRequest paymentRequestDTO);

}
