package me.jonas.cassandrademo.service.impl;

import me.jonas.cassandrademo.dao.PaymentRepository;
import me.jonas.cassandrademo.entity.Payment;
import me.jonas.cassandrademo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }

    @Override
    public Payment getPaymentById(UUID id) {
        Optional<Payment> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return new Payment();
        }
    }

    @Override
    public Payment pay(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public String cancelPayment(UUID id) {
        repository.deleteById(id);
        return "success";
    }

    @Override
    public List<Payment> getPaymentsByCustomer(String sender) {
        return repository.findByCustomer(sender);
    }
}
