package com.paymentgateway.ipg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paymentgateway.ipg.dto.PaymentCreateRequest;
import com.paymentgateway.ipg.dto.PaymentResponseDTO;
import com.paymentgateway.ipg.model.IPGPay;
import com.paymentgateway.ipg.repo.IPGPayRepo;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class IPGPayServiceImpl implements IPGPayService {

    private static final Logger logger = LoggerFactory.getLogger(IPGPayServiceImpl.class);
    private final IPGPayRepo ipgPayRepo;

    @Autowired
    public IPGPayServiceImpl(IPGPayRepo ipgPayRepo) {
        this.ipgPayRepo = ipgPayRepo;
    }

    @Override
    @Transactional
    public PaymentResponseDTO createPayment(@Valid PaymentCreateRequest paymentRequestDTO) {
        try {
            IPGPay payment = convertToEntity(paymentRequestDTO);
            IPGPay savedPayment = ipgPayRepo.save(payment);
            if (savedPayment == null) {
                throw new PaymentCreationException("Failed to save payment");
            }
            return convertToResponseDTO(savedPayment);
        } catch (Exception e) {
            logger.error("Payment creation failed: {}", e.getMessage(), e);
            throw new PaymentCreationException("Payment creation failed", e);
        }
    }

    private IPGPay convertToEntity(PaymentCreateRequest paymentRequestDTO) {
        IPGPay payment = new IPGPay();
        BeanUtils.copyProperties(paymentRequestDTO, payment);
        return payment;
    }

    private PaymentResponseDTO convertToResponseDTO(IPGPay payment) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        BeanUtils.copyProperties(payment, responseDTO);
        return responseDTO;
    }

}




/*@Service
public class IPGPayServiceImpl implements IPGPayService {

     private final IPGPayRepo ipgPayRepo;

    @Autowired
    public IPGPayServiceImpl(IPGPayRepo ipgPayRepo) {
        this.ipgPayRepo = ipgPayRepo;
    }

    @Override
    @Transactional
    public PaymentResponseDTO createPayment(PaymentCreateRequest paymentRequestDTO) {
        try {
            IPGPay payment = convertToEntity(paymentRequestDTO);
            IPGPay savedPayment = ipgPayRepo.save(payment);
            return convertToResponseDTO(savedPayment);
        } catch (Exception e) {
            throw new RuntimeException("Payment creation failed", e);
        }
    }

    private IPGPay convertToEntity(PaymentCreateRequest paymentRequestDTO) {
        IPGPay payment = new IPGPay(); 
        BeanUtils.copyProperties(paymentRequestDTO, payment);
        return payment;
    }

    private PaymentResponseDTO convertToResponseDTO(IPGPay payment) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        BeanUtils.copyProperties(payment, responseDTO);
        return responseDTO;
    }

}
*/