package com.paymentgateway.ipg.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.*;

import lombok.Data;

@Data
@ApiModel(value = "PaymentRequestDTO", description = "Parameters required for a payment")
public class PaymentCreateRequest {

    @ApiModelProperty(notes = "Name of the payment", required = true)
    @NotBlank(message = "Name is required")
    @Size(max = 255)
    private String name;

    @ApiModelProperty(notes = "Number of payment")
    private String number;

    @ApiModelProperty(notes = "Email of the payment")
    private String email;

    @ApiModelProperty(notes = "Address of the payment")
    private String address;

    @ApiModelProperty(notes = "Bill value of the payment")
    private String billValue;

    @ApiModelProperty(notes = "Card number of the payment")
    private String cardNumber;

    @ApiModelProperty(notes = "Card holder of the payment")
    private String cardHolder;

    @ApiModelProperty(notes = "Date value of the payment")
    private String dateValue;

    @Size(max = 3)
    @ApiModelProperty(notes = "CVC of the payment")
    private String cvc;

}
