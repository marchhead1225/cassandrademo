package me.jonas.cassandrademo.service;

import me.jonas.cassandrademo.entity.Payment;

import java.util.List;
import java.util.UUID;


public interface PaymentService {
    List<Payment> getAll();
    Payment getPaymentById(UUID id);
    Payment pay(Payment payment);
    String cancelPayment(UUID id);
    List<Payment> getPaymentsByCustomer(String sender);
}
