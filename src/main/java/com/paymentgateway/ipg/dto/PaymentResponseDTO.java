package com.paymentgateway.ipg.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PaymentResponseDTO", description = "Response object for a payment transaction")
public class PaymentResponseDTO {

    @ApiModelProperty(notes = "Unique identifier for the transaction", required = true)
    private String transactionId;

    @ApiModelProperty(notes = "Status of the payment transaction (e.g., Success, Failed)", required = true)
    private String status;

    @ApiModelProperty(notes = "Detailed message regarding the payment status")
    private String message;

    @ApiModelProperty(notes = "Amount processed in the payment transaction")
    private double amount;

    @ApiModelProperty(notes = "Payment method used for the transaction (e.g., Credit Card, PayPal)")
    private String paymentMethod;

    // Optional: You can add additional fields if necessary
    @ApiModelProperty(notes = "Date and time of the transaction")
    private String transactionDate;
}
