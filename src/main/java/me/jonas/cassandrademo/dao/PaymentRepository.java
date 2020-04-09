package me.jonas.cassandrademo.dao;

import me.jonas.cassandrademo.entity.Payment;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends CassandraRepository<Payment, UUID> {
    @AllowFiltering
    List<Payment> findByCustomer(String customer);

}
