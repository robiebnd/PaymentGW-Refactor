package com.paymentgateway.ipg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentgateway.ipg.model.IPGPay;


@Repository
public interface IPGPayRepo extends JpaRepository<IPGPay, Long> {

}
