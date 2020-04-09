package me.jonas.cassandrademo.controller;


import java.util.List;
import java.util.UUID;

import me.jonas.cassandrademo.entity.Payment;
import me.jonas.cassandrademo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllPayments() {

        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getPaymentById(id),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/customer/{customer}")
    public ResponseEntity getPaymentByFrom(@PathVariable String customer) {
        return new ResponseEntity(service.getPaymentsByCustomer(customer),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payment> getPaymentById(@RequestBody Payment payment) {
        return new ResponseEntity<>(service.pay(payment), HttpStatus.CREATED);
    }

}
