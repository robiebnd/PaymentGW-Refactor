package com.paymentgateway.ipg.controller;

import com.paymentgateway.ipg.service.IPGPayService;

import jakarta.validation.Valid;

import com.paymentgateway.ipg.dto.PaymentCreateRequest;
import com.paymentgateway.ipg.dto.PaymentResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*@RestController
@RequestMapping("/api/payments")
public class IPGPayController {

    private final IPGPayService ipgpayService;

    @Autowired
    public IPGPayController(IPGPayService ipgpayService) {
        this.ipgpayService = ipgpayService;
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponseDTO> createPayment(@Valid @RequestBody PaymentCreateRequest paymentRequestDTO) {
        PaymentResponseDTO createdPayment = ipgpayService.createPayment(paymentRequestDTO);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
}*/

@RestController
@RequestMapping("/api/payments")
public class IPGPayController {

    private static final Logger logger = LoggerFactory.getLogger(IPGPayController.class);
    private final IPGPayService ipgpayService;

    @Autowired
    public IPGPayController(IPGPayService ipgpayService) {
        this.ipgpayService = ipgpayService;
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponseDTO> createPayment(@Valid @RequestBody PaymentCreateRequest paymentRequestDTO) {
        logger.info("Creating payment with request: {}", paymentRequestDTO);
        PaymentResponseDTO createdPayment = ipgpayService.createPayment(paymentRequestDTO);
        logger.info("Payment created with response: {}", createdPayment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }
}