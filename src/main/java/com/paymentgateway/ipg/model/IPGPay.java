package com.paymentgateway.ipg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="Ipgpay")
public class IPGPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String number;
    private String email;
    private String address;
    private String billValue;
    private String cardNumber;
    private String cardHolder;
    private String dateValue;
    private String cvc;

}
